package com.coffee.a10.gson.a3;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

// 序列化：指将一个对象转成 JSON ，Serializer
// 反序列化：指将一个JSON还原为一个普通对象, Deserializer
public class DateTimeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date>
{
	String timeFormat = "yyyy-MM-dd HH:mm:ss";
	
	// 序列化: 输入值 src , 返回值 JsonElement
	@Override
	public JsonElement serialize(Date src, Type typeofT, JsonSerializationContext context)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
		String timeStr = sdf.format(src);
		
		// 可以返回基本类型 : String, Number, Boolean
		// 也可以返回一个 JsonObject, JsonArray ，具体根据你的类型而定
		return new JsonPrimitive( timeStr ); 
	}

	// 反序列化: 输入值 JsonElement
	@Override
	public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
		
		try{
			String timestr = json.getAsString();
			return sdf.parse(timestr);
		}
		catch(Exception e){
			throw new JsonParseException(e.getMessage());
		}
	}

}
