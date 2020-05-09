package com.coffee.a14.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.coffee.a14.controller.MyBatisDB;
import com.coffee.a14.util.SpringException;
import com.coffee.a8.MyBatis;
import com.coffee.entity.Student;

public class InfoService
{
	public int id; // 查找的学号
	public Student stu; // 结果
	public int total; // 总学生人数
	
	public void execute(int id) throws Exception
	{
		this.id = id;
		List<Student> rows = new ArrayList<Student>();		
		try (SqlSession session = MyBatis.factory.openSession()) {			
			 rows = session.selectList("com.coffee.mapper.getStudent");			
		}
		this.total = rows.size();
		
		for(Student s : rows)
		{
			if(s.getId() == id)
			{
				this.stu = s;
				return;
			}
		}
		
		throw new SpringException("无此记录, id=" + id);
	}

	
}
