package com.coffee.a4;

import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.coffee.entity.Student;
import com.google.gson.Gson;

/**
 * 
 * @author coffeeliu
 *默认单例模式@Scope("singleton")
 *多例模式@Scope("prototype")
 */
@Controller 
@Scope("prototype")
public class Singleton
{	

	public Singleton()
	{
		System.out.println("\n** 创建 Singleton 实例 ..." + this.toString() + "\n");		
	}
	
	@GetMapping("/Singleton")
	public ResponseEntity<String> Singleton() 
	{
		System.out.println("helloworld(): " +  this.toString());		
		
		Student stu = new Student();
		stu.setId(20200001);
		stu.setName("刘伟");
		stu.setSex(true);
		stu.setPhone("1381111111");		
		Gson gson=new Gson();
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(gson.toJson(stu));	
	}
}

