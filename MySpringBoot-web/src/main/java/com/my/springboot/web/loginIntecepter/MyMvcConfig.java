package com.my.springboot.web.loginIntecepter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 使用WebMvcConfigurerAdapter来扩展mvc的功能
 * @author yp-tc-m-7129
 *
 */
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter{

 	@Bean //将组件注册在容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
        	
            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                super.addInterceptors(registry);
                //SpringBoot已经做好了静态资源映射，静态资源；  *.css , *.js
                ///**拦截所有请求，过滤掉登录页面请求和登录请求和登出请求
	           registry.addInterceptor(new MyHandlerInterceptor()).addPathPatterns("/**")
	           .excludePathPatterns("/login","/userlogin","/logOut");
            }
        };
        return adapter;
    }
}
