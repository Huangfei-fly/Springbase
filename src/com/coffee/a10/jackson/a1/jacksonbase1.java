package com.coffee.a10.jackson.a1;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
/**
 * Jackson基础1
 * @author coffeeliu
 *
 */
public class jacksonbase1
{
	// 生成 JSON 对象
	public static ObjectNode test1()
	{
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode  j = mapper.createObjectNode();
		j.put("id", 10);
		j.put("name", "shaofa");
		j.put("sex", true);
		j.put("phone", "13810012345");
		
		ArrayNode score = j.putArray("score");
		score.add(98);
		score.add(99);
		score.add(100);
		
		String str = j.toString();
		System.out.println(str);
		
		return j;
	}

	// 从 JSON 对象中提取
	public static void test2(ObjectNode j)
	{
		//int id = j.get("id").asInt();
		int id = j.get("id").asInt(0);
		//
		if (j.has("id"))
		{
			JsonNode je = j.get("id");
			id = je.asInt();
		}

		String name = j.get("name").asText();
		boolean sex = j.get("sex").asBoolean();
		String phone = j.get("phone").asText();

		System.out.println("学生: " + id + "," + name + "," + sex + "," + phone);
		System.out.print("分数: ");

		if (j.has("score"))
		{
			ArrayNode score = (ArrayNode)j.get("score");
			for (int i = 0; i < score.size(); i++)
			{
				int s = score.get(i).asInt();
				System.out.print(s + " ");
			}
		}

	}

	public static void main(String[] args)
	{
		ObjectNode j = test1();

		test2(j);

		System.out.println("Exit.");
	}
}
