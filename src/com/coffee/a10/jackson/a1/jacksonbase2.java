package com.coffee.a10.jackson.a1;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Jackson基础2
 * @author coffeeliu
 *
 */
public class jacksonbase2
{
	// POJO <-> JSON Object
	public static void test1() throws Exception
	{
		Student stu = new Student();
		stu.setId( 20200001);
		stu.setName("Jackson");
		stu.setSex(true);
		stu.setCellphone("138132132132");
		stu.score = new int[]{98,99,100};
		
		// 转换器
		ObjectMapper mapper = new ObjectMapper();
		
		// POJO -> JSON String
		String jsonStr = mapper.writeValueAsString(stu);
		//String jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(stu);
		
		// JSON String -> POJO
		Student stu2 = mapper.readValue(jsonStr, Student.class);
		
		// POJO -> JSON Object
		ObjectNode jsonObj = (ObjectNode)mapper.valueToTree(stu);
				
		// JSON Object -> POJO
		Student stu3 = mapper.treeToValue(jsonObj, Student.class);
		
		System.out.println("Test End.");
		
	}
	
	// List <-> JSON Array
	public static void test2() throws Exception
	{
		List<Student> ls = new ArrayList<>();
		ls.add(new Student(20200001,"貂蝉", true, "13811321321"));
		ls.add(new Student(20200002,"大乔", false, "1383213213"));
		ls.add(new Student(20200003,"小乔", false, "13132132132"));
		
		ObjectMapper mapper = new ObjectMapper();
		// 美观格式输出(带综进的格式)
		//Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		// List -> JSON
		String jsonStr = mapper.writeValueAsString( ls );
		ArrayNode jsonArray = (ArrayNode) mapper.valueToTree(ls);
		
		// 第1种办法: 遍历解析
		List<Student> ls2 = new ArrayList<>();
		for(int i=0; i<jsonArray.size(); i++)
		{
			ObjectNode jsonObj = (ObjectNode)jsonArray.get(i);
			Student s = mapper.treeToValue(jsonObj, Student.class);
			ls2.add( s );
		}
		
		// 第2种办法,先解析为数组，再转成泛型 (推荐 )
		Student[] ls3 = mapper.treeToValue(jsonArray, Student[].class);
		List<Student> ls4 = Arrays.asList(ls3);

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
