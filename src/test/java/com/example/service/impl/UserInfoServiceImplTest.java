package com.example.service.impl;

import com.example.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author jack
 * @date 2018/4/25 14:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoServiceImplTest {
    @Autowired
    private UserInfoServiceImpl service;

    @Test
    public void getUserInfoByName() throws Exception {
        UserInfo userInfo = service.getUserInfoByName("admin");
        System.out.println(userInfo.toString());
    }

    @Test
    public void getUserInfoByEmail() throws Exception {
        UserInfo userInfo = service.getUserInfoByEmail("jackbu1994@gmail.com");
        System.out.println(userInfo.toString());
    }

    @Test
    public void delUserInfo() throws Exception {
        //去数据库查看删除结果
        service.delUserInfo(3);
    }

}