package com.coffee.a10.fastjson.a2;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

/** 仅作参考 
 * 一般应该使用普通字段，而不应用使用特殊的非POJO类型
 * 
 * 在目标之段上定义注解： @JSONField(serializeUsing = MyDateSerializer.class)
 * 
 * @author shaofa
 *
 */
public class MyDateSerializer implements  ObjectSerializer ,ObjectDeserializer
{
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public void write(JSONSerializer serializer, Object object, Object fieldName
			, Type fieldType,  int features) throws IOException
	{
		Date date = (Date)object;		
		serializer.write( sdf.format( date ));		
	}

	@Override
	public <T> T deserialze(DefaultJSONParser parser, Type clazz, Object fieldName)
	{
		JSONLexer lexer = parser.lexer;
		String timeStr = lexer.stringVal();
		try{
			return (T)sdf.parse(timeStr);
		}
		catch(Exception e){
			throw new RuntimeException( e.getMessage());
		}
	}

	@Override
	public int getFastMatchToken()
	{
		return JSONToken.LITERAL_INT;
	}

}
