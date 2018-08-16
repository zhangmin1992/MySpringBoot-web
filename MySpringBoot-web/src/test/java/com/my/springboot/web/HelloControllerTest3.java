package com.my.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * HelloController有依赖的时候，脱离web环境独立运行
 * @SpringBootTest 不能和  @WebMvcTest 同时使用
 * 如果使用MockMvc对象的话，需要另外加上@AutoConfigureMockMvc注解
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
public class HelloControllerTest3 {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testHome() throws Exception {
		//模拟一个mvc环境，期望返回状态吗200
		mvc.perform(MockMvcRequestBuilders.get("/test")).andExpect(MockMvcResultMatchers.status().isOk());
		
		//模拟一个mvc环境，期望返回200并且返回值是index
		mvc.perform(MockMvcRequestBuilders.get("/test")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("index"));
		
		mvc.perform(MockMvcRequestBuilders.get("/test")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		
		//打印返回值，看一大堆中的body
		mvc.perform(MockMvcRequestBuilders.get("/test")).andDo(MockMvcResultHandlers.print());
		
		//确认返回页面是不是login
		//mvc.perform(MockMvcRequestBuilders.get("/login")).andExpect(MockMvcResultMatchers.view().name("/WEB-INF/jsp/login"));
		
		//传递多个参数打印返回值，观察 View name = login
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hello");
		requestBuilder.param("name", "1");
		requestBuilder.param("pw", "1");
		mvc.perform(requestBuilder).andDo(MockMvcResultHandlers.print());
	}
}
