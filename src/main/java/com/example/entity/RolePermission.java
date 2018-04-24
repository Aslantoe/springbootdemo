package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author jack
 * @date 2018/4/24  20:20
 */
@Table(name = "role_permission")
public class RolePermission {
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "perms_id")
    private Integer permsId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermsId() {
        return permsId;
    }

    public void setPermsId(Integer permsId) {
        this.permsId = permsId;
    }
}
