package com.coffee.a13;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.coffee.entity.Student;

/**
 * thymeleaf入门
 * 运行视图
 * http://localhost:8080/Springbase/app/hello.html
 * 预览视图
 * http://localhost:8080/Springbase/app/page/hello.html
 * @author coffeeliu
 *
 */
@Controller
public class Hello13Controller
{
	@GetMapping("/hello.html")
	public String test(Model model)
	{
		Student stu = new Student(20200088, "刘伟", true, "138555555");
		
		model.addAttribute("stu", stu);
				
		return "hello.html"; // 最终合成路径  /page/hello.html
	}
}
