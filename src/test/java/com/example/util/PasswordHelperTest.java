package com.example.util;

import com.example.entity.UserInfo;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jack
 * @date 2018/4/26 0026 15:40
 */
public class PasswordHelperTest {
    @Test
    public void encryptPassword() throws Exception {
        PasswordHelper helper = new PasswordHelper();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserEmail("jackbu1994@163.com");
        userInfo.setUserPassword("admin");
        helper.encryptPassword(userInfo);
        System.out.println(userInfo.toString());
    }

}