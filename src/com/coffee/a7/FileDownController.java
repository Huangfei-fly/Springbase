package com.coffee.a7;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FileDownController
{
/**
 * http://localhost:8080/Springbase/app/res/1.png
 * 静态文件
 * 自定义文件下载
 * http://localhost:8080/Springbase/app/photo/1.png
 * @param id
 * @param request
 * @param response
 * @throws Exception
 */
	@GetMapping("/photo/{id}")
	public void down(@PathVariable int id
			, HttpServletRequest request
			, HttpServletResponse response)	throws Exception
	{
		// 文件名，路径		
		File dir = new File("C:/tmp/photo");
		String fileName = id +"."+ getSuffix(request.getRequestURI());
		File targetFile = new File(dir, fileName);

		// 应答：设置 Content-Type 和 Content-Length 
		//long contentLength = targetFile.length();
		//response.setContentType(getContentType(getSuffix(request.getRequestURI())));
		//response.setHeader("Content-Length", String.valueOf(contentLength));
		//response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));	
		
		// 应答：读取目标文件的数据, 发送给客户端
		InputStream inputStream = new FileInputStream(targetFile);
		OutputStream outputStream = response.getOutputStream();
		try{
			copy (inputStream, outputStream);
		}
		catch(Exception e){
			try{ inputStream.close();} catch(Exception e2){}
		}
		
		outputStream.close();
	}
	
	// 拷贝字节流，从in中读取字节，写入到out中
	private long copy(InputStream in, OutputStream out) throws Exception
	{
		long count = 0;
		byte[] buf = new byte[8192];
		while (true)
		{
			int n = in.read(buf);
			if (n < 0)
				break;
			if (n == 0)
				continue;
			out.write(buf, 0, n);

			count += n;
		}
		return count;
	}
	
	// 获取 URL 里的后缀名，如果没有后缀则返回 ""
	private String getSuffix(String url)
	{
		int p1 = url.lastIndexOf('/');
		if(p1 <0) p1 = 0; // 如果没有/，则从头开始检查
		
		int p2 = url.indexOf('.', p1+1);
		if(p2 > 0)
		{
			return url.substring(p2+1);
		}		
		return "";
	}

	// 根据后缀名，推算 Content-Type
	private String getContentType(String suffix)
	{
		suffix = suffix.toLowerCase();
		if(suffix.equals("jpg")) return "image/jpeg";
		if(suffix.equals("jpeg")) return "image/jpeg";
		if(suffix.equals("png")) return "image/png";
		if(suffix.equals("gif")) return "image/gif";
		if(suffix.equals("html")) return "text/html";
		if(suffix.equals("txt")) return "text/plain";
		if(suffix.equals("js")) return "application/javascript";
		if(suffix.equals("mp4")) return "video/mp4";
		
		return "application/octet-stream"; // 一般的二进制文件类型
	}
	

}
