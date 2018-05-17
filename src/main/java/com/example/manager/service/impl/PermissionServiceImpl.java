package com.example.manager.service.impl;

import com.example.common.entity.Tree;
import com.example.common.service.impl.BaseService;
import com.example.manager.entity.Permission;
import com.example.manager.mapper.PermissionMapper;
import com.example.manager.service.PermissionService;
import com.example.manager.service.RolePermissionService;
import com.example.util.TreeUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * @author jack
 * @date 2018/4/25 15:25
 */
@Service("permissionService")
public class PermissionServiceImpl extends BaseService<Permission> implements PermissionService{

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RolePermissionService rolePermissionService;

    @Override
    public List<Permission> findUserPermissions(String userName) {
        return this.permissionMapper.findUserPermissions(userName);
    }

    @Override
    public List<Permission> findUserMenus(String userName) {
        return this.permissionMapper.findUserMenus(userName);
    }

    @Override
    public List<Permission> findAllMenus(Permission menu) {
        try {
            Example example = new Example(Permission.class);
            Example.Criteria criteria = example.createCriteria();
            if (StringUtils.isNotBlank(menu.getMenuName())) {
                criteria.andCondition("menu_name=", menu.getMenuName());
            }
            if (StringUtils.isNotBlank(menu.getType())) {
                criteria.andCondition("type=", Long.valueOf(menu.getType()));
            }
            example.setOrderByClause("menu_id");
            return this.selectByExample(example);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new ArrayList<Permission>();
        }
    }

    @Override
    public Tree<Permission> getMenuButtonTree() {
        List<Tree<Permission>> trees = new ArrayList<Tree<Permission>>();
        List<Permission> menus = this.findAllMenus(new Permission());
        for (Permission menu : menus) {
            Tree<Permission> tree = new Tree<Permission>();
            tree.setId(menu.getMenuId().toString());
            tree.setParentId(menu.getParentId().toString());
            tree.setText(menu.getMenuName());
            trees.add(tree);
        }
        Tree<Permission> t = TreeUtils.build(trees);
        return t;
    }

    @Override
    public Tree<Permission> getMenuTree() {
        List<Tree<Permission>> trees = new ArrayList<Tree<Permission>>();
        Example example = new Example(Permission.class);
        example.createCriteria().andCondition("type =", 0);
        example.setOrderByClause("create_time");
        List<Permission> menus = this.permissionMapper.selectByExample(example);
        for (Permission menu : menus) {
            Tree<Permission> tree = new Tree<Permission>();
            tree.setId(menu.getMenuId().toString());
            tree.setParentId(menu.getParentId().toString());
            tree.setText(menu.getMenuName());
            trees.add(tree);
        }
        Tree<Permission> t = TreeUtils.build(trees);
        return t;
    }

    @Override
    public Tree<Permission> getUserMenu(String userName) {
        List<Tree<Permission>> trees = new ArrayList<Tree<Permission>>();
        List<Permission> menus = this.findUserMenus(userName);
        for (Permission menu : menus) {
            Tree<Permission> tree = new Tree<Permission>();
            tree.setId(menu.getMenuId().toString());
            tree.setParentId(menu.getParentId().toString());
            tree.setText(menu.getMenuName());
            tree.setIcon(menu.getIcon());
            tree.setUrl(menu.getUrl());
            trees.add(tree);
        }
        Tree<Permission> t = TreeUtils.build(trees);
        return t;
    }

    @Override
    public Permission findByNameAndType(String menuName, String type) {
        Example example = new Example(Permission.class);
        example.createCriteria().andCondition("lower(menu_name)=", menuName.toLowerCase()).andEqualTo("type",
                Long.valueOf(type));
        List<Permission> list = this.permissionMapper.selectByExample(example);
        if (list.size() == 0) {
            return null;
        } else {
            return list.get(0);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addMenu(Permission menu) {
        menu.setCreateTime(new Date());
        if (menu.getParentId() == null)
            menu.setParentId(0l);
        this.save(menu);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteMeuns(String menuIds) {
        List<String> list = Arrays.asList(menuIds.split(","));
        this.batchDelete(list, "menuId", Permission.class);
        this.rolePermissionService.deleteRoleMenusByMenuId(menuIds);
        this.permissionMapper.changeToTop(list);
    }

    @Override
    public Permission findById(Long menuId) {
        return this.selectByKey(menuId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateMenu(Permission menu) {
        menu.setModifyTime(new Date());
        if (menu.getParentId() == null)
            menu.setParentId(0L);
        this.updateNotNull(menu);
    }

}
