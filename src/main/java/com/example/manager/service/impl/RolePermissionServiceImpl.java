package com.example.manager.service.impl;

import com.example.common.service.impl.BaseService;
import com.example.manager.entity.RolePermission;
import com.example.manager.service.RolePermissionService;
import org.springframework.stereotype.Service;


/**
 * @author jack
 * @date 2018/4/27 0027 16:44
 */
@Service("rolePermissionService")
public class RolePermissionServiceImpl extends BaseService<RolePermission> implements RolePermissionService{


    @Override
    public void deleteRoleMenusByRoleId(String roleIds) {

    }

    @Override
    public void deleteRoleMenusByMenuId(String menuIds) {

    }
}
