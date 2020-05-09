package com.coffee.a10.gson.a2;


import java.util.Date;

import com.coffee.entity.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 * Gson自定义转换
 * @author coffeeliu
 *
 */
public class gsonExample
{
	public static void test1()
	{
		Student stu = new Student();
		stu.setId(1);
		stu.setName("liuwei");
		stu.setBirthday( new Date());
						
		// 转换器
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.setDateFormat("yyyy-MM-dd")
				.create();
		
		String jsonStr = gson.toJson( stu );
		System.out.println(jsonStr);
			
		Student t2 = gson.fromJson(jsonStr, Student.class);
		
		System.out.println("Test End.");
		
	}
	
	public static void test2()
	{
		Student stu = new Student();
		stu.setId(1);
		stu.setName("liuwei");
		stu.setBirthday( new Date());
						
		// 转换器
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.registerTypeAdapter(Date.class, new DateAdapter())
				.create();
		
		String jsonStr = gson.toJson( stu );
		System.out.println(jsonStr);
			
		Student t2 = gson.fromJson(jsonStr, Student.class);
		
		System.out.println("Test End.");
		
	}
	
	public static void main(String[] args)
	{
		test2();
		
		System.out.println("Exit.");
	}

}
