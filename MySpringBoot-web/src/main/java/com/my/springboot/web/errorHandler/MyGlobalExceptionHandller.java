//package com.my.springboot.web.errorHandler;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@ControllerAdvice // 作为一个控制层的切面处理
//public class MyGlobalExceptionHandller {
//
//	/**
//	 * 全局异常处理返回页面或数据
//	 * 处理全局异常的方式二
//	 * @return
//	 */
//	@ExceptionHandler(value=Exception.class) // 所有的异常都是Exception子类
//	public String myError(){
//		return "globalError";
//	}
//	
//	/**
//	 * 全局异常处理返回json数据
//	 * @param e
//	 * @return
//	 */
//	@ExceptionHandler(Exception.class)
//    @ResponseBody  // 将返回的对象转成json数据
//    public Map<String,Object> handleException(Exception e){
//        Map<String,Object> map = new HashMap<>();
//        map.put("code","500");
//        map.put("message",e.getMessage());
//        return map;
//    }
//}
