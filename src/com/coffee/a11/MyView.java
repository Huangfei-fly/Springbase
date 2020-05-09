package com.coffee.a11;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;
/**
 * 自定义view
 * @author coffeeliu
 *
 */
public class MyView implements View
{	
	@Override
	public void render(Map<String, ?> model
			, HttpServletRequest request
			, HttpServletResponse response) throws Exception
	{
		/**
		 * 可以直接不使用model获取数据，不强求
		 */
		String message = (String) model.get("message");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		response.getWriter().print( message );
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}



}
