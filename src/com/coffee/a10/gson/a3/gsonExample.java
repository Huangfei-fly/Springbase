package com.coffee.a10.gson.a3;


import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.JsonAdapter;
/**
 *使用注解的方式进行转换
 * @author coffeeliu
 *
 */
public class gsonExample
{
	 class User
	{
		public int id;
		public String name;
		
		@JsonAdapter(DateAdapter.class)	
		public Date birthday; // 生日
		
		@JsonAdapter(DateTimeAdapter.class)	
		public Date lastLoginTime; // 登录时间
		
		
	}
	public static void test()
	{
		User user =new gsonExample().new User();
		user.id = 20200001;
		user.name = "liuwei";
		user.birthday = new Date();
		user.lastLoginTime = new Date();
						
		// 转换器
		Gson gson = new Gson();		
		String jsonStr = gson.toJson( user );
		System.out.println(jsonStr);
			
		User user2 = gson.fromJson(jsonStr, User.class);
		
		System.out.println("Test End.");
		
	}
	
	public static void main(String[] args)
	{
		test();
		
		System.out.println("Exit.");
	}

}
