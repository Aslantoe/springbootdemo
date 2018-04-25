package com.example.service.impl;

import com.example.entity.Permission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author jack
 * @date 2018/4/25 15:30
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionServiceImplTest {

    @Autowired
    private PermissionServiceImpl service;

    @Test
    public void queryAll() throws Exception {
        List<Permission> list = service.queryAll();
        for (Permission permission : list) {
            System.out.println(permission.toString());
        }
    }

    @Test
    public void loadUserPermissions() throws Exception {
        //查看PermissionMapperTest
    }

    @Test
    public void queryPermissionsListWithSelected() throws Exception {
        //查看PermissionMapperTest
    }

}