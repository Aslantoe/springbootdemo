package com.example.mapper;

import com.example.entity.Administrator;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author jack
 * @date 2018/4/12  16:52
 */
public interface AdministratorMapper {
    /**
     * 根据姓名获取管理员信息
     */
    @Select("SELECT * FROM admin where admin_name = ?")
    Administrator getAdministratorByName(String name);

    /**
     * 获取所有管理员信息
     */
    @Select("SELECT * FROM admin")
    @Results({
            @Result(id = true,property = "adminId",column = "admin_id"),
            @Result(id = true,property = "adminName",column = "admin_name"),
            @Result(id = true,property = "adminEmail",column = "admin_email"),
            @Result(id = true,property = "loginTime",column = "logintime"),
            @Result(id = true,property = "createTime",column = "createtime")
    })
    List<Administrator> getAllAdministrator();



}
