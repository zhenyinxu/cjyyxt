package com.vkeline.config.shiroConfig;

import com.vkeline.modules.sys.entity.PermissionEntity;
import com.vkeline.modules.sys.entity.RoleEntity;
import com.vkeline.modules.sys.entity.UserEntity;
import com.vkeline.modules.sys.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.List;


public class DatabaseRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    /**
     * 授权
     *
     *
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        // 授权对象
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        UserEntity userEntity = (UserEntity) principalCollection.getPrimaryPrincipal();
        if(userEntity == null){
            return null;
        }
        //获取用户对应的角色列表与权限列表
        List<RoleEntity> roleEntityList = userEntity.getRoleList();
        //将角色列表与权限列表放进授权对象中
        for (RoleEntity role : roleEntityList){
            info.addRole(role.getId());
            List<PermissionEntity> permissionEntityList = role.getPermissionEntityList();
            for (PermissionEntity permissionEntity : permissionEntityList){
                info.addStringPermission(permissionEntity.getId());
            }
        }

        return info;

    }


    /**
     *
     * 身份认证信息
     *
     */

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

       // UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //从token中获取用户名
        String userName = authenticationToken.getPrincipal().toString();
        // 通过db，用户名查询用户实体
        UserEntity user = userService.findUserEntityByPassport(userName);

        // 获取数据库中的密码
        String passwordInDB = user.getPassword();
        String salt = user.getSalt();

        // 认证信息里存放账号密码, getName() 是当前Realm的继承方法,通常返回当前类名 :databaseRealm
        // 盐也放进去
        // 这样通过applicationContext-shiro.xml里配置的 HashedCredentialsMatcher 进行自动校验
        return new SimpleAuthenticationInfo(userName, passwordInDB, ByteSource.Util.bytes(salt), getName());
    }
}
