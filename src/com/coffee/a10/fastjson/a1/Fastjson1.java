package com.coffee.a10.fastjson.a1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class Fastjson1
{
	// 生成 JSON 对象
	public static JSONObject test1()
	{
		JSONObject j = new JSONObject(true); // true,输出时有序；false,输出时无序
		j.put("id", 10);
		j.put("name", "fastjson");
		j.put("sex", true);
		j.put("phone", "1383213213");
		
		JSONArray score = new JSONArray();
		score.add(98);
		score.add(99);
		score.add(100);
		j.put("score", score);
		
		String str = j.toString(); // 无格式输出
		//str = JSON.toJSONString(j, SerializerFeature.PrettyFormat); // 格式化输出
		System.out.println(str);
		
		
		return j;
	}

	// 从 JSON 对象中提取
	public static void test2(JSONObject j)
	{
		//int id = j.get("id").asInt();
		int id = j.getIntValue("id");
		//
		if (j.containsKey("id"))
		{
			id = j.getIntValue("id");
		}

		String name = j.getString("name");
		boolean sex = j.getBooleanValue("sex");
		String phone = j.getString("phone");

		System.out.println("学生: " + id + "," + name + "," + sex + "," + phone);
		System.out.print("分数: ");

		if (j.containsKey("score"))
		{
			JSONArray score = (JSONArray)j.get("score");
			for (int i = 0; i < score.size(); i++)
			{
				int s = score.getIntValue(i);
				System.out.print(s + " ");
			}
		}

	}

	public static void main(String[] args)
	{
		JSONObject j = test1();

		test2(j);

		System.out.println("Exit.");
	}
}
