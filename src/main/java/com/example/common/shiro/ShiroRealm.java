package com.example.common.shiro;

import com.example.manager.entity.Permission;
import com.example.manager.entity.Role;
import com.example.manager.entity.User;
import com.example.manager.service.PermissionService;
import com.example.manager.service.RoleService;
import com.example.manager.service.UserService;
import com.example.util.Constant;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jack
 * @date 2018/5/18 0018 18:36
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String userName = user.getUsername();

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        List<Role> roleList = this.roleService.findUserRole(userName);
        Set<String> roleSet = new HashSet<>();
        for (Role role : roleList) {
            roleSet.add(role.getRoleName());
        }
        simpleAuthorizationInfo.setRoles(roleSet);

        List<Permission> permissionList = this.permissionService.findUserPermissions(userName);
        Set<String> permissionSet = new HashSet<>();
        for (Permission permission : permissionList) {
            permissionSet.add(permission.getPerms());
        }
        simpleAuthorizationInfo.setStringPermissions(permissionSet);

        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        User user = this.userService.findByName(userName);


        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }
        if (Constant.STATE_LOCKED.equals(user.getStatus())) {
            throw new LockedAccountException("账号已被锁定,请联系管理员！");
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());

        return info;
    }
}
