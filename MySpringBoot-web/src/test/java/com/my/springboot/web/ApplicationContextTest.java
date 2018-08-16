package com.my.springboot.web;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 这个测试启动类的路径要和项目app启动类的路径在同一个目录下或者子目录下，否则启动会报错
 * java.lang.IllegalStateException: Unable to find a @SpringBootConfiguration, you need to use @ContextConfiguration or @SpringBootTest(classes=...) with your test
	at org.springframework.util.Assert.state(Assert.java:70)
	at org.springframework.boot.test.context.SpringBootTestContextBootstrapper.getOrFindConfigurationClasses(SpringBootTestContextBootstrapper.java:202)
	at org.springframework.boot.test.context.SpringBootTestContextBootstrapper.processMergedContextConfiguration(SpringBootTestContextBootstrapper.java:137)
	at org.springframework.test.context.support.AbstractTestContextBootstrapper.buildMergedContextConfiguration(AbstractTestContextBootstrapper.java:409)
	at org.springframework.test.context.support.AbstractTestContextBootstrapper.buildDefaultMergedContextConfiguration(AbstractTestContextBootstrapper.java:323)
 * @author yp-tc-m-7129
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=TestBeanConfiguration.class)
public class ApplicationContextTest {

	@Autowired
	private ApplicationContext context;
	
	@Test
	public void testNull(){
		Assert.assertNotNull(context.getBean(Runnable.class));
	}
	
}
