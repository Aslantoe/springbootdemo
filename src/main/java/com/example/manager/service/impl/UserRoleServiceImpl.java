package com.example.manager.service.impl;

import com.example.common.service.impl.BaseService;
import com.example.manager.entity.UserRole;
import com.example.manager.service.UserRoleService;

import org.springframework.stereotype.Service;

/**
 * @author jack
 * @date 2018/4/27 0027 16:32
 */
@Service("userRoleService")
public class UserRoleServiceImpl extends BaseService<UserRole> implements UserRoleService {

    @Override
    public void deleteUserRolesByRoleId(String roleIds) {

    }

    @Override
    public void deleteUserRolesByUserId(String userIds) {

    }
}
