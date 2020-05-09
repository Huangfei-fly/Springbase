package com.coffee.a12.contorller;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.coffee.a11.RestData;
import com.coffee.a8.MyBatis;
import com.coffee.entity.Student;

/**
 * 自定义异常处理
 * http://localhost:8080/Springbase/app/info.do?id=20200002.1
 * http://localhost:8080/Springbase/app/info.do?id=20222222
 * @author coffeeliu
 *
 */

@Controller
public class StudentEController
{
	@GetMapping("/info.do")
	public Object info(int id)
	{
		Student s = getStudent(id);
		return new RestData(s);    // RestData,a11
	}
	
	// 按学号查找
	private Student getStudent(int id)
	{
       List<Student> rows = new ArrayList<Student>();
		
		try (SqlSession session = MyBatis.factory.openSession()) {			
			 rows = session.selectList("com.coffee.mapper.getStuById",id);			
		}
		for(Student s : rows)
		{
			if(s.getId() == id)
				return s;
		}
		throw new RuntimeException("找不到记录,id=" + id);
	}
}
