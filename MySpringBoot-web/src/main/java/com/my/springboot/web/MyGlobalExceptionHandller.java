package com.my.springboot.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyGlobalExceptionHandller {

	/**
	 * 全局异常处理返回数据非页面了
	 * @return
	 */
	//@ResponseBody
	@ExceptionHandler(value=Exception.class)
	public String myError(){
		return "globalError";
	}
}
