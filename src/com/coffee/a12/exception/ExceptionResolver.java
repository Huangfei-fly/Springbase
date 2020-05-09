package com.coffee.a12.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.coffee.a11.RestError;

/**
 * 自定义错误解析器
 * 无自定义错误
 * @author coffeeliu
 *当注册多个 异常处理器时，@Order决定顺序，Order越低的越先执行
 */
@Order(-100)
public class ExceptionResolver implements HandlerExceptionResolver
{

	@Override
	public ModelAndView resolveException(HttpServletRequest request
			, HttpServletResponse response
			, Object handler
			, Exception exception)
	{
		//HandlerMethod handlerMethod = (HandlerMethod)handler;
		String uri = request.getRequestURI();
		
		// 判断是否为 REST服务
		if(uri.endsWith(".do"))
		{
			Map<String,Object> model = new HashMap<>();
			View view = new RestError(exception);//a12
			System.err.println("访问" + request.getRequestURI() + " 发生错误, 错误信息:" + exception.getMessage());
			
			return new ModelAndView(view, model);
		}
		
		return null; // 返回null表示此Resolver未能处理该异常，则继续按默认方式处理
	}

}
