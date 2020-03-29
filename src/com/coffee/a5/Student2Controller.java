package com.coffee.a5;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.coffee.a2.DemoDB;
import com.coffee.entity.Student;
import com.google.gson.Gson;
/**
 * MVC模式与rest模式比较
 * @author coffeeliu
 *
 */
@Controller
@RequestMapping("/stu")
public class Student2Controller
{
	/**
	 * MVC模式
	 * http://localhost:8080/Springbase/app/stu/query3?from=20200001&to=20200005
	 * @param model
	 * @param from
	 * @param to
	 * @return
	 */
	@GetMapping("/query3")
	public String query( Model model, int from, int to)
	{
		List<Student> studentList = new ArrayList<Student>();			
		for(Student s : DemoDB.list)
		{
			if(s.getId() >= from && s.getId() <= to)
			{
				studentList.add( s );
			}
		}
		
		model.addAttribute("studentList", studentList);
		
		return "query"; // 模板路径 /WEB-INF/template/query.html
	}
	
	/**
	 * rest模式
	 * http://localhost:8080/Springbase/app/stu/query4?from=20200001&to=20200005
	 * @param n1
	 * @param n2
	 * @return
	 */
	@GetMapping("/query4")
	public ResponseEntity<String> query2( @RequestParam("from") Integer n1
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
		// 构造 ResponseEntity 对象返回
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(new Gson().toJson(result));	
	}	
	/**
	 * 上下文对象用法
	 * http://localhost:8080/Springbase/app/stu/login?user=刘伟
	 * @param session
	 * @param user
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@GetMapping("/login")
	public ResponseEntity<String> login(HttpSession session, String user) throws UnsupportedEncodingException 
	{
		user=new String(user.getBytes("iso-8859-1"), "utf-8");
		session.setAttribute("user", user);
		Map<String, Object> jresp=new HashMap<String, Object>();
		jresp.put("error",  0);
		jresp.put("reason", "OK");
		jresp.put("user", user);
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(new Gson().toJson(jresp));	
	}
	
	/**
	 * http://localhost:8080/Springbase/app/stu/mvc/20200001/info
	 * MVC出错跳转处理
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/mvc/{id}/info")
	public String get( Model model, @PathVariable int id)
	{
		Student stu = null;
		for(Student s : DemoDB.list)
		{
			if(s.getId() == id)
			{
				stu = s;
				break;
			}
		}
		// 如果找不到, 则显示错误显示
		if(stu == null) 
		{
			model.addAttribute("errMsg", "找不到记录, id=" + id);
			return "error_404";
			//return "redirect:/a/some.html";
			//return ResponseEntity.status(404).build();
		}
		model.addAttribute("stu", stu);
		return "info";	
	}	
	
	/**
	 * http://localhost:8080/Springbase/app/stu/mvc/20200001/info1
	 * 使用配置文件加载多个ViewResolver
	 * jsp文件自动解析测试
	 * @param id
	 * @return
	 */
	@RequestMapping("/mvc/{id}/info1")
	public ModelAndView  get1( @PathVariable int id)
	{
		Student stu = null;
		for(Student s : DemoDB.list)
		{
			if(s.getId() == id)
			{
				stu = s;
				break;
			}
		}
		ModelAndView mv=new ModelAndView("info1");
		mv.addObject("stu", stu);
		return mv;	
	}
	
	/**
	 * http://localhost:8080/Springbase/app/stu/query5?from=20200001&to=20200005
	 * jsp文件返回集合测试
	 * 导入jstl-1.2 jar包
	 * @param from
	 * @param to
	 * @return
	 */
	@GetMapping("/query5")
	public String query5(HttpSession session,Model model, int from, int to)
	{
		List<Student> studentList = new ArrayList<Student>();			
		for(Student s : DemoDB.list)
		{
			if(s.getId() >= from && s.getId() <= to)
			{
				studentList.add( s );
			}
		}
		session.setAttribute("user", "刘伟");
//		ModelAndView mv=new ModelAndView("query1");
//		mv.addObject("studentList", studentList);
//		return mv;
		model.addAttribute("studentList", studentList);
		return "query1"; // 模板路径 /WEB-INF/jsp/query1.jsp
	}
}
