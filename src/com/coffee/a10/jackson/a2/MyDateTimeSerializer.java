package com.coffee.a10.jackson.a2;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class MyDateTimeSerializer extends JsonSerializer<Date>
{
	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider provider) throws IOException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeStr = sdf.format(value);
		gen.writeString( timeStr );		
	}

}
