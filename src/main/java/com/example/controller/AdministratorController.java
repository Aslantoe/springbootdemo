package com.example.controller;

import com.example.entity.Administrator;
import com.example.service.impl.AdministratorServiceImpl;
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
    public String list(ModelMap map){
        List<Administrator> administrators = administratorService.getAllAdministrator();
        map.addAttribute("administrators",administrators);
        return "list1";
    }

}
