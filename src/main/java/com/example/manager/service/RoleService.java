package com.example.manager.service;

import com.example.common.service.IService;
import com.example.manager.entity.Role;
import com.example.manager.entity.RoleWithPermission;

import java.util.List;

/**
 * @author jack
 * @date 2018/4/24 20:50
 */
public interface RoleService extends IService<Role> {
    List<Role> findUserRole(String userName);

    List<Role> findAllRole(Role role);

    RoleWithPermission findRoleWithMenus(Long roleId);

    Role findByName(String roleName);

    void addRole(Role role, Long[] menuIds);

    void updateRole(Role role, Long[] menuIds);

    void deleteRoles(String roleIds);
}
