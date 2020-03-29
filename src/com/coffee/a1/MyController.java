package com.coffee.a1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.entity.Student;

@RestController
public class MyController
{
	@RequestMapping("/haha")
	public Student myHaha()
	{
		Student stu = new Student();
		stu.setId(20190002);
		stu.setName("haha");
		stu.setSex(false);
		stu.setPhone("13810012345");		
		return stu;
	}
}
