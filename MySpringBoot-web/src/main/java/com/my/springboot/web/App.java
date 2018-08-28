package com.my.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;

/**
 * 方式一二的异常全局处理需要@SpringBootApplication(exclude=ErrorMvcAutoConfiguration.class)
 * 方式三的异常全局处理不能排除ErrorMvcAutoConfiguration，因为他要依赖这个去找4xx.html页面
 * @author yp-tc-m-7129
 *
 */
//@SpringBootApplication(exclude=ErrorMvcAutoConfiguration.class)
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
}
 