package com.coffee.a14.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
/**
 * 自定义错误解析器
 * 2个自定义view针对rest
 * 1个自定义错误针对普通报错
 * @author coffeeliu
 *
 */
@Order(-100)
public class myExceptionResolver implements HandlerExceptionResolver
{

	@Override
	public ModelAndView resolveException(HttpServletRequest request
			, HttpServletResponse response
			, Object handler
			, Exception exception)
	{

		String uri = request.getRequestURI();
		if(uri.endsWith(".do"))
		{
			// REST 出错处理
			Map<String,Object> model = new HashMap<>();
			View view = new RestError(exception);
			System.err.println("访问" + request.getRequestURI() + " 发生错误, 错误信息:" + exception.getMessage());
			
			return new ModelAndView(view, model);
		}
		else
		{
			// MVC 处理
			Map<String,Object> model = new HashMap<>();
			model.put("message", exception.getMessage());
				
			StringWriter stringWriter = new StringWriter();
			exception.printStackTrace(new PrintWriter(stringWriter));
			model.put("detail", stringWriter.toString());
				
			return new ModelAndView("error.html", model);
		}
		
		// return null; // 返回null表示此Resolver未能处理该异常，则继续按默认方式处理
	}

}