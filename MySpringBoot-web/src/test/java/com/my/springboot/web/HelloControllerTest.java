package com.my.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.my.springboot.web.App;

/**
 * web环境下的测试，会启动web容器，耗时较长
 * 启动时间
 * 16:28:42.290
 * 2018-08-16 16:28:47.696
 * @author yp-tc-m-7129
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class,webEnvironment = WebEnvironment.DEFINED_PORT)
public class HelloControllerTest {

	@Autowired
    private Environment env;
	
	/**
	 * 优先找测试环境配置文件，测试环境没有再找主项目的配置文件
	 */
	@Test
    public void test(){
		System.out.println(env.getProperty("my.name"));
	}
	
	@Autowired
    private TestRestTemplate restTemplate;
	
    @Test
    public void test1() throws Exception {
        ResponseEntity<String> response = this.restTemplate.getForEntity("http://localhost:8080/test", String.class);
        System.out.println(String.format("测试结果为：%s", response.getBody()));
    }
}
