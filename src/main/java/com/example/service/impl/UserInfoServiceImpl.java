package com.example.service.impl;

import com.example.entity.UserInfo;
import com.example.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author jack
 * @date 2018/4/23 0023 15:59
 */
@Service
public class UserInfoServiceImpl extends BaseService<UserInfo> implements UserInfoService {
    @Autowired
    private UserInfoService userInfoService;

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
    public void delUserInfo(Integer uid) {

    }
}
