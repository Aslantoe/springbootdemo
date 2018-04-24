package com.example.service;

import com.example.entity.Role;

import java.util.List;

/**
 * @author jack
 * @date 2018/4/24 20:50
 */
public interface RoleService extends IService<Role>{
    List<Role> queryRoleListWithSelected(Integer uid);

    /**
     * 删除角色 同时删除角色资源表中的数据
     * @param roleid 角色ID
     */
    void delRole(Integer roleid);

}
