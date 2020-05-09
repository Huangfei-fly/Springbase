package com.coffee.a10.jackson.a2;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * Jackson自定义转换
 * @author coffeeliu
 *
 */
public class JacksonExample
{
	 class User
	 {
	 	public int id;
	 	public String name;
	 	

	 	@JsonSerialize( using= MyDateSerializer.class)
	 	@JsonDeserialize( using=MyDateDeserializer.class)
	 	public Date birthday; // 生日
	 	
	 	@JsonSerialize( using= MyDateTimeSerializer.class)
	 	@JsonDeserialize( using=MyDateTimeDeserializer.class)	
	 	public Date lastLoginTime; // 登录时间
	 	
	 	
	 }
	 
	public static void test() throws Exception
	{
		User user =new JacksonExample(). new User();
		user.id = 20200001;
		user.name = "Jackson";
		user.birthday = new Date();
		user.lastLoginTime = new Date();
						
		// 转换器
		ObjectMapper mapper = new ObjectMapper();
		
		// 设置全局的时间格式
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		
		String jsonStr = mapper.writeValueAsString( user );
		System.out.println(jsonStr);
			
		User user2 = mapper.readValue( jsonStr, User.class);
		
		System.out.println("Test End.");
		
	}
	
	public static void main(String[] args)
	{
		try
		{
			test();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Exit.");
	}

}
