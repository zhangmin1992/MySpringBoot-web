package com.my.test;

import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;

public class Test {

	/**
	 * 测试使用shiro.ini中配置的信息进行登录-"zhang", "123"
	 * 测试使用自定义安全数据的方式登录-"zhang", "555"
	 */
	@org.junit.Test
	public void testHelloworld(){
		//1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager  
		Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		//2、得到SecurityManager实例 并绑定给SecurityUtils   
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		//3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		try {
		    //4、登录，即身份验证,其会自动委托给 SecurityManager.login 方法进行登录
		    subject.login(token);
		} catch (AuthenticationException e) {
		    System.out.println("用户登录失败");
		}
		System.out.println(subject.isAuthenticated());
		//6、退出,其会自动委托给 SecurityManager.logout 方法退出
		subject.logout();
	}
	
	/**
	 * 测试某个用户是否有某个权限
	 */
	@org.junit.Test
    public void testHasRole() {
		//1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager  
		Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		//2、得到SecurityManager实例 并绑定给SecurityUtils   
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		//3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		try {
		    //4、登录，即身份验证,其会自动委托给 SecurityManager.login 方法进行登录
		    subject.login(token);
		} catch (AuthenticationException e) {
		    System.out.println("用户登录失败");
		}
        //判断拥有角色：role1
        Assert.assertTrue(subject.hasRole("role1"));
        //判断拥有角色：role1 and role2
        Assert.assertTrue(subject.hasAllRoles(Arrays.asList("role1", "role2")));
        //判断拥有角色：role1 and role2 and !role3,返回是否拥有角色的数组
        boolean[] result = subject.hasRoles(Arrays.asList("role1", "role2", "role3"));
        Assert.assertEquals(true, result[0]);
        Assert.assertEquals(true, result[1]);
        Assert.assertEquals(false, result[2]);
        
        //判断权限
        System.out.println(subject.isPermitted("user:create"));
        System.out.println(subject.isPermittedAll("user:update", "user:delete"));
    }
	
	/**
	 * 测试用户的salt
	 */
	@org.junit.Test
    public void testSalt() {
		RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
		String resu = randomNumberGenerator.nextBytes().toHex();
		System.out.println(resu);
		
		RandomNumberGenerator randomNumberGenerator2 = new SecureRandomNumberGenerator();
		String resu2 = randomNumberGenerator2.nextBytes().toHex();
		System.out.println(resu2);
		
	}
}
