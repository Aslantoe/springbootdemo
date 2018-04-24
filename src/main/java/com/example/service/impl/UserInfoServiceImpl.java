package com.example.service.impl;

import com.example.entity.UserInfo;
import com.example.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jack
 * @date 2018/4/23 0023 15:59
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoService userInfoService;

    @Override
    public UserInfo getUserInfoByName(String name) {
        return userInfoService.getUserInfoByName(name);
    }

    @Override
    public UserInfo getUserInfoByEmail(String email) {
        return userInfoService.getUserInfoByEmail(email);
    }
}
