package com.example.service;

import com.example.entity.RolePermission;

/**
 * @author jack
 * @date 2018/4/24 21:01
 */
public interface RolePermissionService extends IService<RolePermission> {

    /**
     * 赋予角色相应权限
     * @param rolePermission 角色权限
     */
    void addRolePermissions(RolePermission rolePermission);

}
