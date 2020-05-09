package com.coffee.a10.jackson.a2;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class MyDateTimeDeserializer extends JsonDeserializer<Date>
{
	@Override
	public Date deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException
	{
		String strValue = parser.getText();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try{
			return sdf.parse(strValue);
		}
		catch(Exception e){
			return null;
		}
	}

}
