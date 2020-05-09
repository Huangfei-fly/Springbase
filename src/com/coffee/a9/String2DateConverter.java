package com.coffee.a9;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
/**
 * 设置统一类型转换器
 * @author coffeeliu
 *
 */
// 从 String -> Date 的转换器
public class String2DateConverter implements Converter<String, Date>
{

	@Override
	public Date convert(String source)
	{
		// 如果字符串长度为10，则使用 yyyy-MM-dd格式，否则 为 yyyy-MM-dd HH:mm:ss格式
		String pattern = source.length()==10 ? "yyyy-MM-dd" : "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            return format.parse(source);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
	}
	
}
