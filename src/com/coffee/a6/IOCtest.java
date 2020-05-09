package com.coffee.a6;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.coffee.entity.Student;

@Controller
public class IOCtest
{

	/**
	 * IOC框架应用
	 * @param request
	 * @param from
	 * @param to
	 * @return
	 */
	@GetMapping("/IOCtesthello")
	public Object query(HttpServletRequest request,int from, int to)
	{
		//全局变量方法一的使用
		  //DemoDB.instance.getList();
		
		// 应用上下文
		WebApplicationContext ctx
			= RequestContextUtils.findWebApplicationContext(request);
		//全局变量方法二的使用
		DemoDB demoDB = ctx.getBean("demoDB", DemoDB.class);
		
		List<Student> source = demoDB.getList();
		
		List<Student> result = new ArrayList<>();		
		for(Student s : source)
		{
			if(s.getId() >= from && s.getId() <= to)
			{
				result.add( s );
			}
		}
		
		// 应答数据
		JSONArray jresp = new JSONArray( result);
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(jresp.toString(2));	
	}
	/**
	 * 三种bean获取方式
	 * @param request
	 * @return
	 */
	@GetMapping("/IOCtest")
	public void test(HttpServletRequest request)
	{
		//方法一
		WebApplicationContext ctx
		= RequestContextUtils.findWebApplicationContext(request);
		//方法二
//		ApplicationContext ctx =WebApplicationContextUtils.
//			getWebApplicationContext(request.getServletContext());
		//方法三
//		 BeanFactory factory=new ClassPathXmlApplicationContext("classpath:*/Hello*.xml");
		
		//bean的获取
//	     Person person=(Person) factory.getBean("alias11",Person.class);
		IOCtestServer iServer = ctx.getBean("IOCtestServer", IOCtestServer.class);
//		IOCtestServer iServer1 = ctx.getBean( IOCtestServer.class);
		
		System.out.println(iServer.getIp()+iServer.getPort());
		
	}
}



