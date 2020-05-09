package com.coffee.a10.gson.a1;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
/**
 * gson基础用法1
 * @author coffeeliu
 *
 */
public class gsonbase1
{
	// 生成  JSON 对象
	public static JsonObject test1()
	{
		JsonObject j = new JsonObject();
		
		j.addProperty("id", 10);
		j.addProperty("name", "gson");
		j.addProperty("sex", true);
		j.addProperty("phone", "1374111111");
		
		JsonArray score = new JsonArray();
		score.add(98);
		score.add(99);
		score.add(100);
		j.add("score", score);;
		
		String str = j.toString();
		System.out.println(str);
		
		return j;
	}
	
	// 从 JSON 对象中提取
	public static void test2(JsonObject j)
	{
		int id = j.get("id").getAsInt();
		
		//
		if(j.has("id"))
		{
			JsonElement je = j.get("id");
			if(! je.isJsonNull())
				id = je.getAsInt();
		}
		
		
		String name = j.get("name").getAsString();
		boolean sex = j.get("sex").getAsBoolean();
		String phone = j.get("phone").getAsString();
		
		System.out.println("学生: " + id + "," + name + "," + sex + "," + phone);
		System.out.print("分数: ");
		
		if( j.has("score"))
		{
			JsonArray score = j.get("score").getAsJsonArray();
			for(int i=0; i<score.size(); i++)
			{
				int s = score.get(i).getAsInt();
				System.out.print(s + " ");
			}
		}	
			
	}
	
	public static void main(String[] args)
	{
		JsonObject j = test1();
		
		test2( j );
		
		System.out.println("Exit.");
	}

}
