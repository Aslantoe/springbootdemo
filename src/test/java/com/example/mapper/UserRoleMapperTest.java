package com.example.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author jack
 * @date 2018/4/27 0027 16:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRoleMapperTest {
    @Autowired
    private UserRoleMapper mapper;

    @Test
    public void findUserIdByRoleId() throws Exception {
        List<Integer> list = mapper.findUserIdByRoleId(2);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

}