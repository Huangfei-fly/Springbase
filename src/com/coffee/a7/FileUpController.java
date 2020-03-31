package com.coffee.a7;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.JsonObject;

@Controller
public class FileUpController
{
	/**
	 * http://localhost:8080/Springbase/a6/upload.html
	 * 无返回值自定义返回方式
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@PostMapping("/upload")
	public void upload(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		MultipartHttpServletRequest mhr = (MultipartHttpServletRequest) request;
		
		String tag = mhr.getParameter("tag");  // 表单里的 name='tag'
		System.out.println("** tag: " + tag);
		
		MultipartFile mf = mhr.getFile("file"); // 表单里的 name='file'
		if(mf != null && !mf.isEmpty())
		{
			File dir = new File("c:/tmp/photo");
			dir.mkdirs();
			
			String fileName = mf.getOriginalFilename();
			File localFile = new File(dir, fileName);
			mf.transferTo(localFile);
			System.out.println("** file: " + localFile.getAbsolutePath());
		}
		
	
		JsonObject jresp=new JsonObject();
		jresp.addProperty("error", 0);
		jresp.addProperty("reason", "OK, 已上传");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		response.getWriter().write(jresp.toString());
	}
}
