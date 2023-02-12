package com.abin.config;

import com.abin.pojo.Permission;
import com.abin.pojo.User;
import com.abin.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

//   授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("执行了授权");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 拿到当前登录的用户，并授权
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        List<Permission> permissionList = user.getRole().getPermission();
        for (Permission permission : permissionList) {
            info.addStringPermission(permission.getPermission());
        }
        return info;
    }
//  认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("执行了认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        List<User> userList = userService.getUser();
        boolean userExist = userList.stream().anyMatch(t -> t.getUsername().equals(token.getUsername()));
        if(!userExist){
            return null;// 用户名认证 会throw UnknownAccountException
        }
        User user = userList.stream().filter(t -> t.getUsername().equals(token.getUsername())).findFirst().get();
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");// 密码认证，shiro做
    }
}
