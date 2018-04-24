package com.example.mapper;

import com.example.entity.Permission;
import com.example.util.MyMapper;

import java.util.List;
import java.util.Map;

/**
 * @author jack
 * @date 2018/4/24 0024 20:37
 */
public interface PermissionMapper extends MyMapper<Permission> {
    List<Permission> queryAll();

    List<Permission> loadUserPermissions(Map<String,Object> map);

    List<Permission> queryPermissionsListWithSelected(Integer pid);
}
