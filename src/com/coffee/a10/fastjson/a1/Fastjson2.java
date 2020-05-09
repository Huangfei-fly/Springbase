package com.coffee.a10.fastjson.a1;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.coffee.a10.gson.a1.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class Fastjson2
{
	// POJO <-> JSON Object
	public static void test1() 
	{
		Student stu = new Student();
		stu.setId( 20200001);
		stu.setName("fastjson");
		stu.setSex(true);
		stu.setCellphone("13813213213");
		stu.score = new int[]{98,99,100};
				
		// POJO -> JSON String
		String jsonStr = JSON.toJSONString(stu);
		//String jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(stu);
		
		// JSON String -> POJO
		Student stu2 = JSON.parseObject(jsonStr, Student.class);
		
		// POJO -> JSON Object
		JSONObject jsonObj = (JSONObject) JSON.toJSON(stu);
				
		// JSON Object -> POJO
		Student stu3 = JSON.toJavaObject(jsonObj, Student.class);
		
		System.out.println("Test End.");
		
	}
	
	// List <-> JSON Array
	public static void test2()
	{
		List<Student> ls = new ArrayList<>();
		ls.add(new Student(20200001,"刘伟", true, "1381000001"));
		ls.add(new Student(20200002,"张飞", false, "13821323132"));
		ls.add(new Student(20200003,"关羽", false, "13723232132"));
		
		
		// List -> JSON
		String jsonStr = JSON.toJSONString( ls );
		JSONArray jsonArray = (JSONArray) JSON.toJSON( ls);
		
		// 第1种办法: 遍历解析
		List<Student> ls2 = new ArrayList<>();
		for(int i=0; i<jsonArray.size(); i++)
		{
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			Student s = JSON.toJavaObject(jsonObj, Student.class);
			ls2.add( s );
		}
		
		// 第2种办法,先解析为数组，再转成泛型 (推荐 )
		Student[] ls3 = JSON.toJavaObject(jsonArray, Student[].class);
		List<Student> ls4 = Arrays.asList(ls3);

		System.out.println("ls:"+ls+"\nls2:"+ls2
				+"\nls4:"+ls4);

		System.out.println("Test End.");
	
	}
	
	public static void main(String[] args)
	{
		try
		{
			test2();
		} catch (Exception e)
		{
			
			e.printStackTrace();
		}
		
		System.out.println("Exit.");
	}

}
