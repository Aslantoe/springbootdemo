package com.example.service.impl;

import com.example.entity.UserInfo;
import com.example.entity.UserRole;
import com.example.mapper.UserRoleMapper;
import com.example.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author jack
 * @date 2018/4/23 0023 15:59
 */
@Service("userService")
public class UserInfoServiceImpl extends BaseService<UserInfo> implements UserInfoService {
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public UserInfo getUserInfoByName(String username) {
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userName",username);
        List<UserInfo> userList = getByExample(example);
        if(userList.size()>0){
            return userList.get(0);
        }
        return null;
    }

    @Override
    public UserInfo getUserInfoByEmail(String email) {
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userEmail",email);
        List<UserInfo> userList = getByExample(example);
        if(userList.size()>0){
            return userList.get(0);
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false,rollbackFor = {Exception.class})
    public void delUserInfo(Integer uid) {
        //删除用户表
        mapper.deleteByPrimaryKey(uid);
        //删除用户角色表
        Example example = new Example(UserRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",uid);
        userRoleMapper.deleteByExample(example);
    }
}
