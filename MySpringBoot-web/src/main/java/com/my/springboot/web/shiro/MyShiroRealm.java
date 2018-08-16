//package com.my.springboot.web.shiro;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.SimpleAuthenticationInfo;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.util.ByteSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.my.springboot.web.shiro.service.UserEntityServiceImpl;
//
//@Component
//public class MyShiroRealm  extends AuthorizingRealm{
//
//	//数据库中获取用户登录数据
//	@Autowired
//	private UserEntityServiceImpl userEntityService;
//	
//	//授权
//	@Override
//	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
//		//从凭证中获得用户名
//		String username = (String) SecurityUtils.getSubject().getPrincipal();
//		
//		 //根据用户名查询用户对象
//		 UserEntity user = new UserEntity(1L, "admin", "admin");
//		 
//		 //查询用户id查询拥有的角色
//		 List<RoleEntity> list = new ArrayList<RoleEntity>();
//		 list.add(new RoleEntity(1L,1l,"all"));
//		 list.add(new RoleEntity(1L,1l,"merchant"));
//		 
//		//赋予用户角色
//		 SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//		 for (RoleEntity role : list) {
//			 info.addStringPermission(role.getRole());
//		 }
//		 return info;
//	}
//
//	//认证
//	@Override
//	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//		 //获得当前用户的用户名
//		 String username = (String) authenticationToken.getPrincipal();
//		 System.out.println("doGetAuthenticationInfo----" +username);
//		 
//		 //不需要特地去数据库查密码，只需要用户名，shiro会调用源码中的doCredentialsMatch来判断数据库密码和加密的密码是否一致
//		 //从数据库中根据用户名查找用户
//		 UserEntity user = userEntityService.getUserByName(username);
//		 if(user == null) {
//			 throw new AuthenticationException("不存在此用户");
//		 }
//		 
//		 //将信息存错
//		 SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(),getName());
//		 //使用salt的方式加密
//		 //SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(),ByteSource.Util.bytes(user.getSalt()),getName());
//		 return info;
//	}
//
//}
