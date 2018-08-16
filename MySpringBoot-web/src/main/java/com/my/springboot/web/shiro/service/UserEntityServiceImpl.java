package com.my.springboot.web.shiro.service;

import org.springframework.stereotype.Service;

import com.my.springboot.web.shiro.UserEntity;

@Service
public class UserEntityServiceImpl {

	public UserEntity getUserByName(String username) {
		if(username.equals("admin")) {
			return new UserEntity(1L, "admin", "admin");
		}else if(username.equals("aa")) {
			return new UserEntity(2L, "aa", "11");
		}else {
			return null;
		}
	}
}
