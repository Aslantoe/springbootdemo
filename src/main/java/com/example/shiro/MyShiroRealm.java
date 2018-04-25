package com.example.shiro;

import com.example.entity.Permission;
import com.example.entity.UserInfo;
import com.example.service.PermissionService;
import com.example.service.UserInfoService;
import com.example.util.Constant;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.util.ByteSource;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;


/**
 * @author jack
 * @date 2018/4/23 15:20
 */
public class MyShiroRealm extends AuthorizingRealm{
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RedisSessionDAO redisSessionDAO;


    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("授权-->MyShiroRealm.doGetAuthorizationInfo");
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userInfo.getUserId());
        List<Permission> permissionList = permissionService.loadUserPermissions(map);
        //权限信息对象info，用来存放查出的用户的所有角色及权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (Permission permission : permissionList) {
            info.addStringPermission(permission.getPermsResUrl());
        }
        return info;
    }

    /**
     * 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("身份认证----->>MyShiroRealm.doGetAuthenticationInfo");
        //获取用户输入的账号
        String usermail = (String) token.getPrincipal();
         System.out.println("token.getCredentials()---->" + token.getCredentials());
         //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法

        UserInfo userInfo = userInfoService.getUserInfoByEmail(usermail );
        if(userInfo == null) {
            throw new UnknownAccountException();
        }
        if(Constant.STATE_LOCKED == userInfo.getUserState()){
            throw new LockedAccountException();
        }
        System.out.println("---->UserInfo：" + userInfo.toString());

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
          userInfo,
          userInfo.getUserPassword(),
          ByteSource.Util.bytes(userInfo.getCredentialsSalt()),
          //realm name
          getName()
        );
        //当验证都通过后，把用户信息放在session里
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("userSession",userInfo);
        session.setAttribute("userId",userInfo.getUserId());
        return authenticationInfo;
    }
    /**
     * 根据userId 清除当前session存在的用户的权限缓存
     * @param userIds 已经修改了权限的userId
     */
    public void clearUserAuthByUserId(List<Integer> userIds){
        if(null == userIds || userIds.size() == 0) { return; }
        //获取所有session
        Collection<Session> sessions = redisSessionDAO.getActiveSessions();
        //定义返回
        List<SimplePrincipalCollection> list = new ArrayList<>();
        for (Session session : sessions){
            //获取session登录信息。
            Object obj = session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            if(null != obj && obj instanceof SimplePrincipalCollection){
                //强转
                SimplePrincipalCollection spc = (SimplePrincipalCollection)obj;
                //判断用户，匹配用户ID。
                obj = spc.getPrimaryPrincipal();
                if(null != obj && obj instanceof UserInfo){
                    UserInfo user = (UserInfo) obj;
                    System.out.println("userInfo----->" + user.toString());
                    //比较用户ID，符合即加入集合
                    if(user != null&& userIds.contains(user.getUserId())){
                        list.add(spc);
                    }
                }
            }
        }
        RealmSecurityManager securityManager =
                (RealmSecurityManager) SecurityUtils.getSecurityManager();
        MyShiroRealm realm = (MyShiroRealm)securityManager.getRealms().iterator().next();
        for (SimplePrincipalCollection simplePrincipalCollection : list) {
            realm.clearCachedAuthorizationInfo(simplePrincipalCollection);
        }
    }
}
