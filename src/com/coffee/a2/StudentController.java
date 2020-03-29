package com.coffee.a2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.entity.Student;
/**
 * 
 * rest提交的三种形式
 * @author coffeeliu
 *
 */
@RestController
@RequestMapping("/stu")//共享前缀可以不加
public class StudentController
{
	//get形式
	//http://localhost:8080/Springbase/stu/app/query?from=20200001&to=20200005
	@GetMapping("/query")
	public List<Student> query(Integer from, Integer to)
	{
		List<Student> result = new ArrayList<Student>();
		
		for(Student s : DemoDB.list)
		{
			if(s.getId() >= from && s.getId() <= to)
			{
				result.add( s );
			}
		}
		
		return result;		
	}
	
	@GetMapping("/query1")
	public List<Student> query1( @RequestParam("from") Integer n1
			, @RequestParam("to") Integer n2)
	{
		List<Student> result = new ArrayList<Student>();
		
		for(Student s : DemoDB.list)
		{
			if(s.getId() >= n1 && s.getId() <= n2)
			{
				result.add( s );
			}
		}
		
		return result;		
	}
	//post传统表单形式
	@PostMapping("/add")
	public Map add( int id, String name, boolean sex, String phone)
	{
		Student stu = new Student(id,name,sex, phone);
		DemoDB.list.add( stu );
		System.out.println("添加了一条记录: " + name);
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("error", 0); // 错误码，0表示成功
		result.put("reason", "OK"); // 错误描述
		return result;
	}
	//post json形式
	@PostMapping("/add2")
	public Map add2( @RequestBody Student stu)
	{
		//Student stu = new Student(id,name,sex, phone);
		DemoDB.list.add( stu );
		System.out.println("添加了一条记录: " + stu.getName());
		
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("error", 0); // 错误码，0表示成功
		result.put("reason", "OK"); // 错误描述
		return result;
	}
	
	
}
