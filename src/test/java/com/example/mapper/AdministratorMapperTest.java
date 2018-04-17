package com.example.mapper;

import com.example.entity.Administrator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author jack
 * @date 2018/4/12 0012 19:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdministratorMapperTest {
    @Autowired
    private AdministratorMapper mapper;
    @Test
    public void testGetAll(){
        List<Administrator> list = mapper.getAllAdministrator();
        for (Administrator administrator : list) {
            System.out.println(administrator.toString());
        }
    }
}
