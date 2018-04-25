package com.example.mapper;

import com.example.entity.Permission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author jack
 * @date 2018/4/25 17:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionMapperTest {
    @Autowired
    private PermissionMapper mapper;

    @Test
    public void loadUserPermissions() throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",2);
       // map.put("type","test");
        List<Permission> list = mapper.loadUserPermissions(map);
        for (Permission permission : list) {
            System.out.println(permission.toString());
        }
    }

    @Test
    public void queryPermissionsListWithSelected() throws Exception {
        List<Permission> list = mapper.queryPermissionsListWithSelected(1);
        for (Permission permission : list) {
            System.out.println(permission.toString());
        }
    }

}