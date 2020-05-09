package com.coffee.a14.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sun.org.apache.bcel.internal.generic.NEW;


public class RestError implements RestView
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
		if(e instanceof SpringException)
		{
			SpringException e2 = (SpringException)e;
			this.error = e2.error;
			this.reason = e2.reason;
		}
		else
		{
			this.error = -1;
			this.reason = e.getMessage();
		}
		
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
		response.getWriter().print( new Gson().toJson(json) );
	}
	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

}
