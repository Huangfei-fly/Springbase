package com.coffee.a10.gson.a1;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
/**
 * gson基础用法2
 * @author coffeeliu
 *
 */
public class gsonbase2
{
	// POJO <-> JSON Object
	public static void test1()
	{
		Student stu = new Student();
		stu.setId( 20200001);
		stu.setName("gson");
		stu.setSex(true);
		stu.setCellphone("1381111111");
		stu.score = new int[]{48,99,100};
		
		// 转换器
		Gson gson = new Gson();
		// 使用生成器生成复杂模式
		//Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		// POJO -> JSON String
		String jsonStr = gson.toJson(stu); 
		
		// POJO -> JSON Object
		JsonElement jsonObj = gson.toJsonTree(stu);
		
		// JSON String -> POJO
		Student stu2 = gson.fromJson(jsonStr, Student.class);
		
		// JSON Object -> POJO
		Student stu3 = gson.fromJson(jsonObj, Student.class);
		
		System.out.println("jsonStr:"+jsonStr+"\njsonObj:"+jsonObj
				+"\nstu2:"+stu2+"\nstu3:"+stu3);
		System.out.println("Test End.");
		
		
	}
	
	// List <-> JSON Array
	public static void test2()
	{
		List<Student> ls = new ArrayList<>();
		ls.add(new Student(20200001,"刘伟", true, "1381000001"));
		ls.add(new Student(20200002,"张飞", false, "13821323132"));
		ls.add(new Student(20200003,"关羽", false, "13723232132"));
		
		Gson gson = new Gson();
		// 美观格式输出(带综进的格式)
		//Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		// List -> JSON
		String jsonStr = gson.toJson(ls);
		JsonArray jsonArray = (JsonArray) gson.toJsonTree(ls);
		System.out.println(jsonStr+"\n;"+jsonArray);
		// 第1种办法: 遍历解析
		List<Student> ls2 = new ArrayList<>();
		for(int i=0; i<jsonArray.size(); i++)
		{
			JsonObject jsonObj = jsonArray.get(i).getAsJsonObject();
			Student s = gson.fromJson(jsonObj, Student.class);
			ls2.add( s );
		}
		
		// 第2种办法,先解析为数组，再转成泛型 
		Student[] ls3 = gson.fromJson(jsonArray, Student[].class);
		List<Student> ls4 = Arrays.asList(ls3);
		// 第3种办法，直接解析成泛型 (导入java.lang.reflect.Type)
		Type type = new TypeToken<List<Student>>(){}.getType();
		List<Student> ls5 = new Gson().fromJson(jsonStr, type);

		System.out.println("ls:"+ls+"\nls2:"+ls2
				+"\nls4:"+ls4+"\nls5:"+ls5.get(0).score[0]);
		System.out.println("Test End.");
	
	}
	
	public static void main(String[] args)
	{
		test2();
		//test1();
		System.out.println("Exit.");
	}

}
