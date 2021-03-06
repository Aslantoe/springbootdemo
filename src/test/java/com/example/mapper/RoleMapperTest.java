package com.example.mapper;

import com.example.manager.entity.Role;
import com.example.manager.entity.RoleWithPermission;
import com.example.manager.mapper.RoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author jack
 * @date 2018/4/20 0020 17:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleMapperTest {

    @Autowired
    private RoleMapper mapper;

    @Test
    public void findUserRole(){
       List<Role> list = mapper.findUserRole("scott");
        for (Role role : list) {
            System.out.println(role.toString());
        }
    }

    @Test
    public void roleWithPermission(){
       List<RoleWithPermission> list = mapper.findById(23L);
        for (RoleWithPermission roleWithPermission : list) {
            System.out.println(roleWithPermission.toString());
        }
    }

}
