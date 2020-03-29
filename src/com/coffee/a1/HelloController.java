package com.coffee.a1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.entity.Student;

@RestController
public class HelloController
{	
	@RequestMapping("/hello")
	public Student helloworld() 
	{
		Student stu = new Student();
		stu.setId(20200001);
		stu.setName("刘伟");
		stu.setSex(true);
		stu.setPhone("13810011111");		
		return stu;
	}
}

