package com.coffee.a11;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
/**
 * 自定义错误风格应答
 * @author coffeeliu
 *
 */
public class RestError implements View
{	
	public int error = -1;
	public String reason = "";
	
	public RestError()
	{		
	}
	public RestError(int error)
	{
		this.error = error;
	}
	public RestError(String reason)
	{
		this.reason = reason;
	}
	public RestError(int error, String reason)
	{
		this.error = error;
		this.reason = reason;
	}
	public RestError(Exception e)
	{
		reason = e.getMessage();
		if(reason == null)
			reason = e.getClass().getName();
	}
	
	@Override
	public void render(Map<String, ?> model
			, HttpServletRequest request
			, HttpServletResponse response) throws Exception
	{
		JsonObject json = new JsonObject();
		json.addProperty("error", error);
		json.addProperty("reason", reason);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		response.getWriter().print(  new Gson().toJson(json) );
	}
	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

}
