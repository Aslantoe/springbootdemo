package com.example.util;

import com.example.entity.UserInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author jack
 * @date 2018/4/26  15:34
 */
public class PasswordHelper {
    private String algorithmName = "md5";
    private int hashIterations = 2;

    public void encryptPassword(UserInfo user){
        String newPassword = new SimpleHash(algorithmName,
                                            user.getUserPassword(),
                                            ByteSource.Util.bytes(user.getUserEmail()),
                                            hashIterations).toHex();
        user.setUserPassword(newPassword);
    }
}
