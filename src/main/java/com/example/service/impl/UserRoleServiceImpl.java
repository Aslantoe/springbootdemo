package com.example.service.impl;

import com.example.entity.UserRole;
import com.example.service.UserRoleService;
import com.example.shiro.MyShiroRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 * @date 2018/4/27 0027 16:32
 */
@Service("userRoleService")
public class UserRoleServiceImpl extends BaseService<UserRole> implements UserRoleService{
    @Autowired
    private MyShiroRealm myShiroRealm;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false,rollbackFor = {Exception.class})
    public void addUserRole(UserRole userRole) {
        //删除
        Example example = new Example(UserRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",userRole.getUserId());
        mapper.deleteByExample(example);
        //添加
        Integer roleid = userRole.getRoleId();
        UserRole ur = new UserRole();
        ur.setRoleId(roleid);
        ur.setUserId(userRole.getUserId());
        mapper.insert(ur);

        //更新当前登录用户的权限缓存
        List<Integer> useridList = new ArrayList<>();
        useridList.add(userRole.getUserId());
        myShiroRealm.clearUserAuthByUserId(useridList);

    }
}
