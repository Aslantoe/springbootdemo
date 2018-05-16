package com.example.mapper;

import com.example.manager.entity.User;
import com.example.manager.entity.UserWithRole;
import com.example.manager.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


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
    public void findUserWithRole(){
         List<UserWithRole> list = mapper.findUserWithRole(23L);
        for (UserWithRole user : list) {
            System.out.println(user.toString());
        }
    }


    @Test
    public void findAllUser(){
        List<User> list = mapper.selectAll();
        for (User user : list) {
            System.out.println(user.toString());
        }
    }

}
