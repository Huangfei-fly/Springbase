package com.coffee.a10.fastjson.a2;


import java.text.SimpleDateFormat;
import java.util.Date;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
/**
 * Fastjson自定义转换
 * @author coffeeliu
 *
 */
public class FastJsonExample03
{
	public class User
	{
		public int id;
		public String name;
		
		@JSONField(format="yyyy-MM-dd")
		public Date birthday; // 生日
		
		@JSONField(format="yyyy-MM-dd HH:mm:ss")
		public Date lastLoginTime; // 登录时间
	}
	
	public static void test() throws Exception
	{
		User user = new FastJsonExample03().new User();
		user.id = 20200001;
		user.name = "fastjson";
		user.birthday = new Date();
		user.lastLoginTime = new Date();
						
		String jsonStr = JSON.toJSONString( user);
		System.out.println(jsonStr);
			
		User user2 = JSON.parseObject(jsonStr, User.class);
		
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
