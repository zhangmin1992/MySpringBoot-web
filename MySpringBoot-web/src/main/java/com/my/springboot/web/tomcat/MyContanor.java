//package com.my.springboot.web.tomcat;
//
//import org.apache.catalina.connector.Connector;
//import org.apache.catalina.valves.AccessLogValve;
//import org.apache.coyote.http11.Http11NioProtocol;
//import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
//import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
//import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
//import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
//import org.springframework.stereotype.Component;
//
///**
// * 第一种定制化tomcat的方式
// * 1.实现接口，EmbeddedServletContainerCustomizer，并把接口纳入容器管理
// * 默认支持容器是tomcat，此处是tomcat容器的私人定制
// * @author yp-tc-m-7129
// *
// */
//@Component
//public class MyContanor implements EmbeddedServletContainerCustomizer {
//
//	@Override
//	public void customize(ConfigurableEmbeddedServletContainer container) {
//		System.out.println("默认的容器类型是"+ container.getClass());
//		TomcatEmbeddedServletContainerFactory factory = (TomcatEmbeddedServletContainerFactory)container;
//		factory.setPort(10003);
//		factory.addContextValves(getLogAccessLogValve());
//		factory.addConnectorCustomizers(new MyTomcatConnectorCustomizer());
//	}
//	
//	/**
//	 * 等同于资源文件中的配置
//	 * #server.tomcat.accesslog.enabled=true  日志打开，默认是关闭的
//	 * #server.tomcat.accesslog.directory=/Users/yp-tc-m-7129/logs/  日志的地址
//	 *  日志的前缀
//	 *  日志的后缀
//	 *  日志的格式 %h %l %u %t \"%r\" %s %b
//	 *  新产生的文件的地址是：/Users/yp-tc-m-7129/logs/springboot-access-log.2018-08-16.txt
//	 * @return
//	 */
//	private AccessLogValve getLogAccessLogValve(){
//		AccessLogValve log = new AccessLogValve();
//		log.setEnabled(true);
//		log.setDirectory("/Users/yp-tc-m-7129/logs/");
//		log.setPattern("%h %l %u %t \"%r\" %s %b");
//		log.setPrefix("springboot-access-log");
//		log.setSuffix(".txt");
//		return log;
//	}
//
//}
//
//class MyTomcatConnectorCustomizer implements TomcatConnectorCustomizer {
//
//	public void customize(Connector connector) {
//		System.out.println("容器协议默认类型是" +connector.getClass());
//		Http11NioProtocol protocol = (Http11NioProtocol)connector.getProtocolHandler();
//		protocol.setMaxConnections(50);//设置最大连接数
//		protocol.setMaxThreads(10);//设置最大的线程数
//	}
//}
