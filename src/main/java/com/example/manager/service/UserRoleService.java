package com.example.manager.service;

import com.example.common.service.IService;
import com.example.manager.entity.UserRole;

/**
 * @author jack
 */
public interface UserRoleService extends IService<UserRole> {
    void deleteUserRolesByRoleId(String roleIds);

    void deleteUserRolesByUserId(String userIds);
}
