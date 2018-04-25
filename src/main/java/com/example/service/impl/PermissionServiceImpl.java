package com.example.service.impl;

import com.example.entity.Permission;
import com.example.mapper.PermissionMapper;
import com.example.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author jack
 * @date 2018/4/25 15:25
 */
@Service("permissionService")
public class PermissionServiceImpl extends BaseService<Permission> implements PermissionService{
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> queryAll() {
        return permissionMapper.selectAll();
    }

    @Override
    public List<Permission> loadUserPermissions(Map<String, Object> map) {
        return permissionMapper.loadUserPermissions(map);
    }

    @Override
    public List<Permission> queryPermissionsListWithSelected(Integer rid) {
        return permissionMapper.queryPermissionsListWithSelected(rid);
    }
}
