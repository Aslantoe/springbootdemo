package com.example.service;

import com.example.entity.UserRole;

/**
 * @author jack
 * @date 2018/4/24 20:59
 */
public interface UserRoleService extends IService<UserRole> {
    /**
     * 赋予用户角色
     * @param userRole 用户角色
     */
    void addUserRole(UserRole userRole);

}
