package com.example.controller;


import com.example.service.impl.AdministratorServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

/**
 * @author jack
 * @date 2018/4/12 17:05
 */
@Controller
public class AdministratorController {
    @Autowired
    private AdministratorServiceImpl administratorService;

    @RequestMapping("/admin")
    public String list(String email,String password){
        System.out.println(email+"---"+password);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(email,password);
        try {
            subject.login(token);
        }catch (Exception e){
            e.printStackTrace();
        }


        //map.addAttribute("administrators",administrators);
        return "login_admin";
    }

}
