package com.example.controller;

import com.example.entity.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jack
 * @date 2018/4/26 15:46
 */
@Controller
public class LoginAdminController {
    @RequestMapping(value = "/login_admin",method = RequestMethod.GET)
    public String login(){
        return "login_admin";
    }
    @RequestMapping(value = "/login_admin",method = RequestMethod.POST)
    public String login(HttpServletRequest request, UserInfo user, Model model){
        if(StringUtil.isEmpty(user.getUserEmail()) || StringUtil.isEmpty(user.getUserPassword())){
            request.setAttribute("msg","用户名或密码不能为空!");
            return "login_admin";
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserEmail(),user.getUserPassword());
        try{
            subject.login(token);
            return "redirect:usersPage";
        }catch (LockedAccountException lae){
            token.clear();
            request.setAttribute("msg","用户已经被锁定不能登录，请与管理员联系!");
            return "login_admin";
        }catch (AuthenticationException e){
            token.clear();
            request.setAttribute("msg","用户名或密码不正确!");
            return "login_admin";
        }
    }
    @RequestMapping(value={"/usersPage",""})
    public String usersPage(){
        return "user/users";
    }

    @RequestMapping("/rolesPage")
    public String rolesPage(){
        return "role/roles";
    }

    @RequestMapping("/resourcesPage")
    public String resourcesPage(){
        return "resources/resources";
    }

    @RequestMapping("/403")
    public String forbidden(){
        return "403";
    }

}
