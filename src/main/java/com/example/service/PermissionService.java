package com.example.service;

import com.example.entity.Permission;

import java.util.List;
import java.util.Map;

/**
 * @author jack
 * @date 2018/4/24 0024 20:54
 */
public interface PermissionService extends IService<Permission> {
    /**
     * 获取全部权限
     * @return 权限列表
     */
    List<Permission> queryAll();

    /**
     * 加载用户权限
     * @param map
     * @return 权限列表
     */
    List<Permission> loadUserPermissions(Map<String,Object> map);

    /**
     * 根据所选角色获取其权限列表
     * @param rid 角色ID
     * @return 权限列表
     */
    List<Permission> queryPermissionsListWithSelected(Integer rid);
}
