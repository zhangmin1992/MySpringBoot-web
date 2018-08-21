package com.my.springboot.web.internalProperties;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

/**
 * 中英文切换需要的地域解析器，根据参数来决定是显示中文英文还是默认
 * @author yp-tc-m-7129
 *
 */
@Component(value="localeResolver")
public class MyLocalResolver implements LocaleResolver {

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		String param = request.getParameter("p");
		Locale locale = Locale.getDefault();
		if(param !="" && param!=null ) {
			//切割字符串得到语言代码和国家代码
			String[] temp = param.split("_");
			locale = new Locale(temp[0],temp[1]);
		}
		return locale;
	}

	@Override
	public void setLocale(HttpServletRequest request,
			HttpServletResponse response, Locale locale) {
		locale.setDefault(Locale.ENGLISH);
	}

}
