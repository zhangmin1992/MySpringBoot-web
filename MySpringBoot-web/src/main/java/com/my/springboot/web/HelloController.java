package com.my.springboot.web;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.arjuna.ats.internal.arjuna.objectstore.jdbc.drivers.ibm_driver;

@Controller
public class HelloController {

	/**
	 * 测试main启动后jsp页面可以访问
	 * @param name
	 * @param pw
	 * @return
	 */
	@RequestMapping(value="/hello")
	public String hello(@RequestParam(value="name") String name,@RequestParam(value="pw") String pw) {
		if(name.equals(pw)) {
			return "login";
		}else {
			return "no";
		}
	}
	
	/**
	 * 测试web环境正常
	 * @return
	 */
	@RequestMapping(value="/test")
	@ResponseBody
	public String test() {
		return "index";
	}
	
	/**
	 * 登录首页
	 * @return
	 */
	@RequestMapping(value="/login")
	public String login() {
		System.out.println("我即将进入login页面");
		return "login";
	}
	
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @param vcode
	 * @param rememberMe
	 * @return
	 */
	@RequestMapping(value="/userlogin",method=RequestMethod.POST)
    public String userlogin(String username, String password,HttpSession session){
        System.out.println(username+"----"+password);
        /*if(username.equals("aa") && password.equals("11")) {
        	return "loginSuccess";
        }else {
        	 return "no";
        }*/
        
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            token.clear();
            return "no";
        }
        //登录成功后加入缓存
        return "loginSuccess";
    }
	
	/**
	 * 用户注销，
	 * @param session
	 * @return
	 */
	@RequestMapping("/logOut")
    public String logOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        session.removeAttribute("user");
        return "login";
    }
	
	//某用户某权限才可以访问的页面
	@RequiresRoles("admin")
    @RequiresPermissions("create")
	@ResponseBody
    @RequestMapping(value = "/create")
    public String create(){
        return "Create success!";
    }
	
	/**
	 * 设置本类的异常处理
	 */
	@RequestMapping(value = "/testException")
    public void testException(){
        throw new IllegalArgumentException("参数为空");
    }
	
	@RequestMapping(value = "/testException2")
    public void testException2(){
        int i = 10 /0;
    }
	
	@ExceptionHandler(value=IllegalArgumentException.class)
	public String myError(){
		return "error";
	}
	

}