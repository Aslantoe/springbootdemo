package com.example.service.impl;

import com.example.entity.RolePermission;
import com.example.mapper.UserRoleMapper;
import com.example.service.RolePermissionService;
import com.example.shiro.MyShiroRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author jack
 * @date 2018/4/27 0027 16:44
 */
@Service("rolePermissionService")
public class RolePermissionServiceImpl extends BaseService<RolePermission> implements RolePermissionService{
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private MyShiroRealm myShiroRealm;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false,rollbackFor = {Exception.class})
    public void addRolePermissions(RolePermission rolePermission) {
        //删除
        Example example = new Example(RolePermission.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleId",rolePermission.getRoleId());
        mapper.deleteByExample(example);
        //添加
        if(rolePermission.getPermsId() != null){
            Integer permsId = rolePermission.getPermsId();
            RolePermission rp = new RolePermission();
            rp.setPermsId(permsId);
            rp.setRoleId(rolePermission.getRoleId());
            mapper.insert(rp);
        }
        //更新当前登录用户权限缓存
        List<Integer> userIds = userRoleMapper.findUserIdByRoleId(rolePermission.getRoleId());
        myShiroRealm.clearUserAuthByUserId(userIds);
    }

}
