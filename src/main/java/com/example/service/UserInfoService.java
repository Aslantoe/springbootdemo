package com.example.service;

import com.example.entity.UserInfo;

/**
 * @author jack
 * @date 2018/4/23 15:57
 */
public interface UserInfoService extends IService<UserInfo>{
    /**
     * 根据用户姓名获取用户信息
     * @param name 姓名
     * @return 用户信息
     */
    UserInfo getUserInfoByName(String name);
    /**
     * 根据用户邮箱获取用户信息
     * @param email 邮箱
     * @return 用户信息
     */
    UserInfo getUserInfoByEmail(String email);

    /**
     * 根据用户id删除用户信息
     * @param uid 用户id
     */
    void delUserInfo(Integer uid);
}
