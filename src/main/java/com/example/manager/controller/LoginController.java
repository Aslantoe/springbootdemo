package com.example.manager.controller;

import com.example.common.annotation.Log;
import com.example.common.controller.BaseController;
import com.example.common.entity.ResponseBo;
import com.example.manager.entity.User;
import com.example.manager.service.UserService;
import com.example.util.MD5Utils;
import com.example.util.vcode.Captcha;
import com.example.util.vcode.GifCaptcha;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jack
 * @date 2018/5/17 0017 23:23
 */
@Controller
public class LoginController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/login_admin")
    public String login(){
        System.out.println("login________________");
        return "manager/login";
    }

    @PostMapping("/login_admin")
    @ResponseBody
    public ResponseBo login(String username, String password, String code, Boolean rememberMe){
        System.out.println("################  "+username+"\t"+password+"\t"+code+"\t"+rememberMe);
        if(StringUtils.isBlank(code)){
            return ResponseBo.warn("验证码不能为空! ");
        }

        Session session = super.getSession();
        String sessionCode = (String) session.getAttribute("_code");
        if(!code.toLowerCase().equals(sessionCode)){
            return ResponseBo.warn("验证码错误! ");
        }

        password = MD5Utils.encrypt(username.toLowerCase(), password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        try {
            super.login(token);
            this.userService.updateLoginTime(username);
            return ResponseBo.ok();
        } catch (UnknownAccountException e) {
            return ResponseBo.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return ResponseBo.error(e.getMessage());
        } catch (LockedAccountException e) {
            return ResponseBo.error(e.getMessage());
        } catch (AuthenticationException e) {
            return ResponseBo.error("认证失败！");
        }
    }
    @GetMapping(value = "gifCode")
    public void getGifCode(HttpServletResponse response, HttpServletRequest request) {
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/gif");

            Captcha captcha = new GifCaptcha(146, 33, 4);
            captcha.out(response.getOutputStream());
            Session session = super.getSession();
            session.removeAttribute("_code");
            session.setAttribute("_code", captcha.text().toLowerCase());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }

    @GetMapping("/403")
    public String forbid() {
        return "403";
    }

    @Log("访问系统")
    @RequestMapping("/index")
    public String index_admin(Model model) {
        User user = super.getCurrentUser();
        model.addAttribute("user", user);
        return "manager/index_admin";
    }
}
