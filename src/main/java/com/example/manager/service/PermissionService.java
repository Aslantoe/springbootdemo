package com.example.manager.service;

import com.example.common.entity.Tree;
import com.example.common.service.IService;
import com.example.manager.entity.Permission;

import java.util.List;

/**
 * @author jack
 */
public interface PermissionService extends IService<Permission> {
    List<Permission> findUserPermissions(String userName);

    List<Permission> findUserMenus(String userName);

    List<Permission> findAllMenus(Permission menu);

    Tree<Permission> getMenuButtonTree();

    Tree<Permission> getMenuTree();

    Tree<Permission> getUserMenu(String userName);

    Permission findById(Long menuId);

    Permission findByNameAndType(String menuName, String type);

    void addMenu(Permission menu);

    void updateMenu(Permission menu);

    void deleteMeuns(String menuIds);
}
