package com.coffee.a3;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.coffee.a2.DemoDB;
import com.coffee.entity.Student;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
/**
 * 自定义rest应答以及自定义rest请求
 * @author coffeeliu
 * 不使用Jackson JSON，用你自己熟悉的JSON库
 *自定义 ResponseEntity 的构造

1 返回错误码
例如：
return ResponseEntity.status(404).build();
或 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

2 返回成功 
返回成功，正文为 "Yes,welcome!"。例如，
return ResponseEntity.ok("Yes,welcome!");
或 return ResponseEntity.ok().body("Yes,welcome!");

3 完全形式：同时指定Status, Header, Body
例如
	return ResponseEntity.ok()
				.header("Set-Cookie", "UserName=shaofa")
.contentType(MediaType.APPLICATION_JSON_UTF8)
				.cacheControl(CacheControl.maxAge(5, TimeUnit.SECONDS))
				.body("This is example");
使用 header() , cacheControl(), etag(), lastModified() 可以在应答里添加一些Header信息。

4 MediaType
这个类型用于指定 Content-Type，里面定义了很多常量。比如，
MediaType.APPLICATION_JSON_UTF8 对应于 "application/json;charset=UTF-8"
 */
@Controller
public class Student1Controller
{
	//http://localhost:8080/Springbase/app/query2?from=20200001&to=20200005
	@GetMapping(path="/query2")
	public ResponseEntity<String> query( @RequestParam("from") Integer n1
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
		
		// 构造一个JSON对象 
		Gson gson=new Gson();
		String str =gson.toJson(result); 
		
		// 构造 ResponseEntity 对象返回
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(str);
	}
	
	@PostMapping(path="/add3")
	public ResponseEntity<String> add( @RequestBody String content)
	{    
		Gson gson=new Gson();	
		Student stu = gson.fromJson(content, Student.class);		
		DemoDB.list.add( stu );
		System.out.println("添加了一条记录: " + stu.getName());
		
		JsonObject jresp = new JsonObject();
		jresp.addProperty("error", 0); // 错误码，0表示成功
		jresp.addProperty("reason", "OK"); // 错误描述
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(jresp.toString());	
	}	

}
