package com.example.service.impl;

import com.example.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author jack
 * @date 2018/4/25 14:58
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceImplTest {
    @Autowired
    private RoleServiceImpl service;

    @Test
    public void queryRoleListWithSelected() throws Exception {
        List<Role> list = service.queryRoleListWithSelected(2);
        for (Role role : list) {
            System.out.println(role.toString());
        }
    }

    @Test
    public void delRole() throws Exception {
        service.delRole(4);
    }

}