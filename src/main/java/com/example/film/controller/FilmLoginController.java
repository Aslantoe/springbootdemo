package com.example.film.controller;

import com.example.common.controller.BaseController;
import com.example.common.entity.ResponseBo;
import com.example.manager.service.UserService;
import com.example.util.MD5Utils;
import org.apache.shiro.authc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jack
 * @date 2018/5/17 0017 23:23
 */
@Controller
public class FilmLoginController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/login_film")
    public String login_film(){
        System.out.println("################login_film");
        return "index_film";
    }

    @PostMapping("/login_film")
    @ResponseBody
    public ResponseBo login_film(String username, String password, Boolean rememberMe){
        System.out.println("################  "+username+"\t"+password+"\t"+rememberMe);

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

}
