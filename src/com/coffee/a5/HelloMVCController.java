package com.coffee.a5;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.coffee.entity.Student;
/**
 * http://localhost:8080/Springbase/app/hellomvc
 * @author coffeeliu
 *
 */
@Controller
public class HelloMVCController
{
	@GetMapping("/hellomvc")
	public String test(Model model)
	{
		Student stu = new Student(20200001, "刘伟", true, "1388888888");
		
		model.addAttribute("stu", stu);
				
		return "hello"; // 最终合成路径 /WEB-INF/template/hello.html
	}
}
