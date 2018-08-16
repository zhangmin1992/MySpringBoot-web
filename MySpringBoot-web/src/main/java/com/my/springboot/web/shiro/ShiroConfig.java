//package com.my.springboot.web.shiro;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.apache.shiro.spring.LifecycleBeanPostProcessor;
//import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
//
//@Configuration
//public class ShiroConfig {
//
//	 //Filter工厂，设置对应的过滤条件和跳转条件
//	 @Bean
//	 public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
//		    ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//	        shiroFilterFactoryBean.setSecurityManager(securityManager);
//	        Map<String,String> map = new HashMap<String, String>();
//	        
//	       // anon表示可以匿名访问，也即是配置不会被拦截的链接 顺序判断，有静态资源，真正登录和登出
//	        map.put("/static/**", "anon");
//	        map.put("/userlogin", "anon");
//	        map.put("/create","anon");
//	        map.put("/logout","logout");
//
//	        //authc表示拦截访问 对所有用户认证
//	        map.put("/**","authc");
//	        //登录
//	        shiroFilterFactoryBean.setLoginUrl("/login");
//	        //登录成功跳转页面
//	        shiroFilterFactoryBean.setSuccessUrl("/loginSuccess");
//	        //错误页面，认证不通过跳转
//	        shiroFilterFactoryBean.setUnauthorizedUrl("/no");
//	        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
//	        return shiroFilterFactoryBean;
//	 }
//	 
//	 //权限管理，配置主要是Realm的管理认证
//	 @Bean
//	 public DefaultWebSecurityManager securityManager() {
//		 DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager(MyShiroRealm());
//		 return defaultWebSecurityManager;
//	 }
//	 
//	 //把自己实现的权限和认证注册到容器中
//	 @Bean
//	 public MyShiroRealm MyShiroRealm() {
//		 return new MyShiroRealm();
//	 }
//	 
//	 /**
//	  * 注解生效需要加载的bean	 
//	  * @param securityManager
//	  * @return
//	*/
//	@Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
//        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
//        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
//        return authorizationAttributeSourceAdvisor;
//    }
//	 
//	 @Bean
//	 public LifecycleBeanPostProcessor LifecycleBeanPostProcessor() {
//		 return new LifecycleBeanPostProcessor();
//	 }
//	 
//	/* @Bean
//	 public DefaultAdvisorAutoProxyCreator DefaultAdvisorAutoProxyCreator() {
//		 DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
//		 return defaultAdvisorAutoProxyCreator;
//	 }*/
//	
//}
