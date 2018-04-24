package com.example.entity;

import javax.persistence.*;

/**
 * @author jack
 * @date 2018/4/20 0020 15:02
 */
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "role_desc")
    private String roleDesc;
    @Column(name = "role_available")
    private Boolean roleAvailable = Boolean.FALSE;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Boolean getRoleAvailable() {
        return roleAvailable;
    }

    public void setRoleAvailable(Boolean roleAvailable) {
        this.roleAvailable = roleAvailable;
    }


    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", roleAvailable=" + roleAvailable +
                '}';
    }
}
