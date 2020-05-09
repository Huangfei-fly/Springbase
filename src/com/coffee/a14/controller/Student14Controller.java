package com.coffee.a14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coffee.a14.service.InfoService;
import com.coffee.a14.util.SpringUtil;
/**
 * mvc流程优化
 * http://localhost:8080/Springbase/app/a14info/20200001
 * 自定义错误优化
 * http://localhost:8080/Springbase/app/a14info/2020
 * @author coffeeliu
 *
 */
@Controller
//@RequestMapping("/student")
public class Student14Controller
{
	@GetMapping("/a14info/{id}")
	public String info(Model model, @PathVariable int id) throws Exception
	{
		InfoService service = new InfoService();
		service.execute( id );
		
		SpringUtil.putModel(model, service);
//		model.addAttribute("id", service.id); // 待查找的学号
//		model.addAttribute("total", service.total); // 总人数
//		model.addAttribute("stu", service.stu); // 目标结果
		return "info.html";
	}
}
