package com.coffee.a10.gson.a4;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coffee.a10.gson.a1.Student;

/**
 * gson与spring整合
 * jackson,fastjson整合相同不再单独写代码
 * @author coffeeliu
 *
 */
@Controller
@RequestMapping("/studenta10gson")
public class StudentControllergsona4
{
	@PostMapping("/add")
	@ResponseBody
	public Map add(@RequestBody Student stu)
	{
		System.out.println("新增: " + stu.id + "," + stu.name);
		
		Map<String,Object> result = new HashMap<>();
		result.put("error", 0);
		result.put("reason", "OK");
		return result;
	}
}
