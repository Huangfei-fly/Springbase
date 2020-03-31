package com.coffee.a8;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Scope;

import com.coffee.entity.Student;


public class stuService {
	
	public List<Student> excute() {
		List<Student> rows = new ArrayList<Student>();
		
		try (SqlSession session = MyBatis.factory.openSession()) {			
			 rows = session.selectList("com.coffee.mapper.getStudent");			
		}
		return rows;
	}
	
}
