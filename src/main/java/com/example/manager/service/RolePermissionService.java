package com.example.manager.service;

import com.example.common.service.IService;
import com.example.manager.entity.RolePermission;

/**
 * @author jack
 * @date 2018/4/24 21:01
 */
public interface RolePermissionService extends IService<RolePermission> {
    void deleteRoleMenusByRoleId(String roleIds);

    void deleteRoleMenusByMenuId(String menuIds);
}
