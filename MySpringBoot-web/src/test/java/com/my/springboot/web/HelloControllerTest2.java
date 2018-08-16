package com.my.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.MultiValueMap;

/**
 * ==============适用于HelloController没有依赖的时候=========================
 *  @WebMvcTest 不会加载整个spring容器,@WebMvcTest 不需要运行在web环境下，耗时较短
 * 但是，需要指定controllers，表示需要测试哪些controllers
 * 这种方式只测试controller，controller里面的一些依赖，需要你自己去mock
 * 启动时间18:03:05.355
 * 2018-08-16 18:03:19.249
 * 
 * @author yp-tc-m-7129
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers=HelloController.class)
public class HelloControllerTest2 {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testHome() throws Exception {
		//模拟一个mvc环境，期望返回状态吗200
		//mvc.perform(MockMvcRequestBuilders.get("/test")).andExpect(MockMvcResultMatchers.status().isOk());
		
		//模拟一个mvc环境，期望返回200并且返回值是index
		//mvc.perform(MockMvcRequestBuilders.get("/test")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("index"));
		
		//mvc.perform(MockMvcRequestBuilders.get("/test")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		
		//打印返回值，看一大堆中的body
		//mvc.perform(MockMvcRequestBuilders.get("/test")).andDo(MockMvcResultHandlers.print());
		
		//确认返回页面是不是login
		//mvc.perform(MockMvcRequestBuilders.get("/login")).andExpect(MockMvcResultMatchers.view().name("/WEB-INF/jsp/login"));
		
		//传递多个参数打印返回值，观察 View name = login
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hello");
		requestBuilder.param("name", "1");
		requestBuilder.param("pw", "1");
		mvc.perform(requestBuilder).andDo(MockMvcResultHandlers.print());
	}
}
