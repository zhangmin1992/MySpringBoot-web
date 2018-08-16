//package com.my.springboot.web.tomcat;
//
//import org.apache.catalina.valves.AccessLogValve;
//import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
//import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
//import org.springframework.boot.web.servlet.ErrorPage;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//
///**
// * 定制化的tomcat方式二,注入一个TomcatEmbeddedServletContainerFactorybean
// * @author yp-tc-m-7129
// *
// */
//@Configuration
//public class WebServerConfiguration {
//
//	@Bean
//	public EmbeddedServletContainerFactory createEmbeddedServletContainerFactory(){
//		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
//		factory.setPort(10008);
//		//factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
//		factory.addInitializers((servletContext) -> {
//			System.out.println("=========servletContext startup==========");
//			servletContext.setAttribute("startup", "true");
//		});
//		factory.addContextValves(getLogAccessLogValve());
//		return factory;
//	}
//	
//	private AccessLogValve getLogAccessLogValve(){
//		AccessLogValve log = new AccessLogValve();
//		log.setDirectory("/Users/yp-tc-m-7129/logs/");
//		log.setEnabled(true);
//		log.setPattern("%h %l %u %t \"%r\" %s %b");
//		log.setPrefix("springboot-access-log2");
//		log.setSuffix(".txt");
//		return log;
//	}
//}
