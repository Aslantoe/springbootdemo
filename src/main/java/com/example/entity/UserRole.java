package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author jack
 * @date 2018/4/24  20:11
 */
@Table(name = "user_role")
public class UserRole implements Serializable{
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "role_id")
    private Integer roleId;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
