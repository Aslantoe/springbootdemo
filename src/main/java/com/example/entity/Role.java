package com.example.entity;

import java.util.List;

/**
 * @author jack
 * @date 2018/4/20 0020 15:02
 */
public class Role {
    private Integer roleId;
    private String roleName;
    private String roleDesc;
    private Boolean roleAvailable = Boolean.FALSE;
    /**
     * 角色--权限关系：多对多
     */
    private List<Permission> permissions;
    /**
     * 用户--角色关系:多对多
     *  一个角色对应多个用户
     */
    private List<UserInfo> userInfos;

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

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<UserInfo> getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(List<UserInfo> userInfos) {
        this.userInfos = userInfos;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", roleAvailable=" + roleAvailable +
                ", permissions=" + permissions +
                ", userInfos=" + userInfos +
                '}';
    }
}
