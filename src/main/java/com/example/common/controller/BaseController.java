package com.example.common.controller;

import com.example.manager.entity.User;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 * @date 2018/5/16 0016 19:11
 */
public class BaseController {
    protected Map<String, Object> getDataTable(PageInfo<?> pageInfo){
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows",pageInfo.getList());
        rspData.put("total",pageInfo.getTotal());
        return rspData;
    }

    public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }

    protected User getCurrentUser(){
        return (User) getSubject().getPrincipal();
    }

    protected Session getSession(){
        return getSubject().getSession();
    }

    protected Session getSession(Boolean flag){
        return getSubject().getSession(flag);
    }

    protected void login(AuthenticationToken token){
        getSubject().login(token);
    }

}
