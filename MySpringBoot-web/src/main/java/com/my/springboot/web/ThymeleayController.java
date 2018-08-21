package com.my.springboot.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.springboot.web.shiro.UserEntity;

@Controller
public class ThymeleayController {

	//查出用户数据，在页面展示
    @RequestMapping("/testThymeleay")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("arrays",Arrays.asList("zhangsan","lisi","wangwu"));
        ArrayList<UserEntity> list = new ArrayList<>();
        list.add(new UserEntity(1L, "mm", "pp"));
        list.add(new UserEntity(2L, "mm2", "pp2"));
        map.put("list", list);
        return "thymeleleay";
    }
    
    @ResponseBody
    @RequestMapping("/upload")
    public String success(@RequestParam("text") String text){
    	return "提交表单";
    }
}
