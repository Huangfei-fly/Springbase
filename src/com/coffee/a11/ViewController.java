package com.coffee.a11;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.thymeleaf.spring4.expression.Mvc;

import com.coffee.entity.Student;


/**
 * 自定义view玩法以及modelandview玩法（modelandview这个玩法是正规玩法同时也是最常用玩法）
 * http://localhost:8080/Springbase/app/a11view
 * http://localhost:8080/Springbase/app/a11modelandview
 * @author coffeeliu
 *
 */
@Controller
public class ViewController
{
/**
 * 自定义view
 * 一旦自定义view就和模版无关了
 * @param model
 * @return
 */
	@GetMapping("/a11view")
	public Object a11(Model model)
	{		
		
		View view = new MyView();
		model.addAttribute("message", "这是自定义view的玩法，"+view.toString());
		return view;
	}
	/**
	 * 自定义modelandview
	 * @return
	 */
	@GetMapping("/a11modelandview")
	public Object hello3()
	{		
		Map<String,Object> model = new HashMap<>();
		View view = new MyView();
		model.put("message", "modelandview 最常用玩法"+view.toString());

		ModelAndView mv=new ModelAndView(view, model);
		System.out.println(mv.toString());
		return mv;
		
	}
	/**
	 * 
	 * 自定义rest风格应答
	 * 没有进行错误处理纯应答
	 * @return
	 */
	@GetMapping("/a11restdata/{id}")
	public View name(@PathVariable int id) {
		if (id==1) {
			return new RestData(new Student(11, "liuwei", true, "11212121212"));
		}else {
			return new RestError(id);
		}
		
		
	}
}
