package com.example.manager.entity;

import java.util.List;

/**
 * @author jack
 * @date 2018/5/16 0016 23:31
 */
public class UserWithRole extends UserInfo {
    private static final long serialVersionUID = -394205822352672578L;

    private Long RoleId;

    private List<Long> roleIds;

    public Long getRoleId() {
        return RoleId;
    }

    public void setRoleId(Long roleId) {
        RoleId = roleId;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

}
