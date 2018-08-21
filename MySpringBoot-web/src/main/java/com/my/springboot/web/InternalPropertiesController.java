package com.my.springboot.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javassist.expr.NewArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.my.springboot.web.shiro.UserEntity;

@Controller
public class InternalPropertiesController {

//	@Autowired
//	private MessageSource messageSource;
	
	 @RequestMapping("/testInteralProperties")
     public String internalProperties(Model model,@RequestParam(value="name") String name){
		HashMap<String, String> map = new HashMap<>();
		model.addAttribute("mymap", map);
        ArrayList<UserEntity> list = new ArrayList<>();
        list.add(new UserEntity(1L, "mm", "pp"));
        model.addAttribute("mylist", list);
        BigDecimal num = new BigDecimal("23.946");
        model.addAttribute("num", num);
        model.addAttribute("address", "我的地址");
        model.addAttribute("birthday",new Date());
        return "internalProperties";
     }
}
