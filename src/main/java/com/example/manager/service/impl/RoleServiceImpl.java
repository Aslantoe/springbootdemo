package com.example.manager.service.impl;

import com.example.common.service.impl.BaseService;
import com.example.manager.entity.Role;
import com.example.manager.entity.RolePermission;
import com.example.manager.entity.RoleWithPermission;
import com.example.manager.mapper.RoleMapper;
import com.example.manager.mapper.RolePermissionMapper;
import com.example.manager.service.RolePermissionService;
import com.example.manager.service.RoleService;
import com.example.manager.service.UserRoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author jack
 * @date 2018/4/25 14:49
 */
@Service("roleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RoleServiceImpl extends BaseService<Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @Override
    public List<Role> findUserRole(String userName) {
        return this.roleMapper.findUserRole(userName);
    }

    @Override
    public List<Role> findAllRole(Role role) {
        try {
            Example example = new Example(Role.class);
            if (StringUtils.isNotBlank(role.getRoleName())) {
                example.createCriteria().andCondition("role_name=", role.getRoleName());
            }
            example.setOrderByClause("create_time");
            return this.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Role>();
        }
    }

    @Override
    public Role findByName(String roleName) {
        Example example = new Example(Role.class);
        example.createCriteria().andCondition("lower(role_name)=", roleName.toLowerCase());
        List<Role> list = this.roleMapper.selectByExample(example);
        if (list.size() == 0) {
            return null;
        } else {
            return list.get(0);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addRole(Role role, Long[] menuIds) {
        role.setCreateTime(new Date());
        this.save(role);
        for (Long menuId : menuIds) {
            RolePermission rp = new RolePermission();
            rp.setMenuId(menuId);
            rp.setRoleId(role.getRoleId());
            this.rolePermissionMapper.insert(rp);
        }
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteRoles(String roleIds) {
        List<String> list = Arrays.asList(roleIds.split(","));
        this.batchDelete(list, "roleId", Role.class);

        this.rolePermissionService.deleteRoleMenusByRoleId(roleIds);
        this.userRoleService.deleteUserRolesByRoleId(roleIds);

    }

    @Override
    public RoleWithPermission findRoleWithMenus(Long roleId) {
        List<RoleWithPermission> list = this.roleMapper.findById(roleId);
        List<Long> menuList = new ArrayList<Long>();
        for (RoleWithPermission rwp : list) {
            menuList.add(rwp.getMenuId());
        }
        if (list.size() == 0) {
            return null;
        }
        RoleWithPermission roleWithMenu = list.get(0);
        roleWithMenu.setMenuIds(menuList);
        return roleWithMenu;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateRole(Role role, Long[] menuIds) {
        role.setModifyTime(new Date());
        this.roleMapper.updateByPrimaryKeySelective(role);
        Example example = new Example(RolePermission.class);
        example.createCriteria().andCondition("role_id=", role.getRoleId());
        this.rolePermissionMapper.deleteByExample(example);
        for (Long menuId : menuIds) {
            RolePermission rp = new RolePermission();
            rp.setMenuId(menuId);
            rp.setRoleId(role.getRoleId());
            this.rolePermissionMapper.insert(rp);
        }
    }

}
