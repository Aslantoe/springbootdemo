package com.example.mapper;

import com.example.entity.UserInfo;
import com.example.service.UserInfoService;
import com.example.service.impl.UserInfoServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

/**
 * @author jack
 * @date 2018/4/23 15:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserInfoServiceImpl service;

    @Test
    public void getUserInfoByName(){

       UserInfo userInfo = service.getUserInfoByName("admin");
       System.out.println(userInfo.toString());

    }
    @Test
    public void getUserInfoByEmail(){
       UserInfo userInfo = service.getUserInfoByEmail("jackbu1994@gmail.com");
      System.out.println(userInfo.toString());
    }

}
