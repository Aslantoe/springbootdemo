package com.example.shiro;

import com.example.entity.UserInfo;
import com.example.service.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author jack
 * @date 2018/4/23 15:20
 */
public class MyShiroRealm extends AuthorizingRealm{
    @Autowired
    private UserInfoService userInfoService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
       /* System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo = (UserInfo) principals.getPrimaryPrincipal();
        for (Role role : userInfo.getRoleList()) {
            authorizationInfo.addRole(role.getRoleName());
            for (Permission perms : role.getPermissions()) {
                authorizationInfo.addStringPermission(perms.getPermsDesc());
            }
            
        }
        return authorizationInfo;*/
       return null;
    }

    /**
     * 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("身份认证方法----->>MyShiroRealm.doGetAuthenticationInfo");
        //获取用户输入的账号
        String usermail = (String) token.getPrincipal();
        System.out.println("token.getCredentials()---->" + token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserInfo userInfo = userInfoService.getUserInfoByEmail(usermail );
        if(userInfo == null) {return  null;}
        System.out.println("---->UserInfo：" + userInfo.toString());


        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
          userInfo,
          userInfo.getUserPassword(),
          ByteSource.Util.bytes(userInfo.getCredentialsSalt()),
          //realm name
          getName()
        );
        return authenticationInfo;
    }
}
