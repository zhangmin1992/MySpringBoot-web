//package com.my.springboot.web.errorHandler;
//
//import org.springframework.boot.web.servlet.ErrorPage;
//import org.springframework.boot.web.servlet.ErrorPageRegistrar;
//import org.springframework.boot.web.servlet.ErrorPageRegistry;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//
///**
// * 处理全局异常的方式一：比较简单统一指挥
// * 换成自己的错误页面，包括404和500
// * 路径找不到转到自己的404页面
// * 默认异常报错500，
// * 指定异常报错会进入指定页面
// * @author yp-tc-m-7129
// *
// */
//@Component
//public class MyEorrorPageRegistry implements ErrorPageRegistrar {
//
//	@Override
//	public void registerErrorPages(ErrorPageRegistry registry) {
//		ErrorPage e404Page = new ErrorPage(HttpStatus.NOT_FOUND,"/404.html");
//		ErrorPage e500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/500.html");
//		ErrorPage errorPage = new ErrorPage(IllegalArgumentException.class,"/error.html");
//		registry.addErrorPages(e404Page,e500Page,errorPage);
//	}
//	
//
//}
