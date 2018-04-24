package com.example.mapper;

import com.example.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jack
 * @date 2018/4/23 15:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper mapper;

    @Test
    public void getUserInfoByName(){
        UserInfo userInfo = mapper.getUserInfoByUserName("jack");
        System.out.println(userInfo.toString());
    }
    @Test
    public void getUserInfoByEmail(){
        UserInfo userInfo = mapper.getUserInfoByUserEmail("jackbu1994@gmail.com");
        System.out.println(userInfo.toString());
    }
}
