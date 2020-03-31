package com.coffee.a8;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coffee.entity.Student;
import com.google.gson.Gson;



@Controller
@RequestMapping("/stu")
public class Student3Controller
{
	/**
	 * http://localhost:8080/Springbase/app/stu/queryM
	 * mybatis简单整合
	 * @return
	 */
	@GetMapping("/queryM")
	public Object query()
	{
		List<Student> rows = new ArrayList<>();
		
		// 数据库查询
		stuService service=new stuService();
		rows=service.excute();
		
		// 返回应答
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body( new Gson().toJson(rows));
	}
}
