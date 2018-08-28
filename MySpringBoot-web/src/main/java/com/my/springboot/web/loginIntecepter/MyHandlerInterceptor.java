//package com.my.springboot.web.loginIntecepter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
///**
// * 登录拦截器
// * @author yp-tc-m-7129
// *
// */
//public class MyHandlerInterceptor implements HandlerInterceptor{
//
//	@Override
//	public boolean preHandle(HttpServletRequest request,
//			HttpServletResponse response, Object handler) throws Exception {
//		//如果已经有缓存的用户名就不拦截当前请求，防止已经登录成功，请求A请求发现需要拦截再次拦截
//		Object user = request.getSession().getAttribute("username"); 
//		System.out.println("---登录用户---"+user);
//		if(user == null) {
//			request.setAttribute("msg", "用户需要先登录");
//			request.getRequestDispatcher("login").forward(request, response);
//			return false;
//		}else {
//			return true;
//		}
//	}
//
//	@Override
//	public void postHandle(HttpServletRequest request,
//			HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void afterCompletion(HttpServletRequest request,
//			HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//}
