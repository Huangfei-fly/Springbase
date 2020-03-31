package com.coffee.a6;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContextUtils;


//	 BeanFactory factory=new ClassPathXmlApplicationContext("classpath:*/Hello*.xml");
//     Person person=(Person) factory.getBean("alias11",Person.class);
@Controller
public class IOCtest
{
	/**
	 * 三种bean获取方式
	 * @param request
	 * @return
	 */
	@GetMapping("/IOCtest")
	public void test(HttpServletRequest request)
	{
		WebApplicationContext ctx
		= RequestContextUtils.findWebApplicationContext(request);
//		ApplicationContext ctx =WebApplicationContextUtils.
//			getWebApplicationContext(request.getServletContext());
		IOCtestServer iServer = ctx.getBean("IOCtestServer", IOCtestServer.class);
		System.out.println(iServer.getIp()+iServer.getPort());
		
	}
}



