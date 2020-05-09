package com.coffee.a11;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
/**
 * 自定义rest风格应答
 * @author coffeeliu
 *
 */
public class RestData implements View
{	
	Object data;
	
	public RestData(Object data)
	{
		this.data = data;
	}
		
	@Override
	public void render(Map<String, ?> model
			, HttpServletRequest request
			, HttpServletResponse response) throws Exception
	{
		JsonObject json = new JsonObject();
		json.addProperty("error", 0);
		json.addProperty("reason", "OK");
		if(data != null)
		{
			if(data instanceof JsonElement) // 本身就是 JsonObject 或 JsonArray
				json.add("data",  (JsonElement) data);
			else
				
				json.add("data",new JsonParser().parse(new Gson().toJson(data)) );
		}

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
