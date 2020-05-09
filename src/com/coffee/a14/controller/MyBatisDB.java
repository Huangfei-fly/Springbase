package com.coffee.a14.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/** 
 * 
 */
public class MyBatisDB
{	
public static SqlSessionFactory factory;
	
	// 静态代码块：首次调用时初始化
	static{
		System.out.println("** MyBatis factory 初始化 ...");

		// 静态代码块: 初始化 SqlSessionFactory 实例
		try{
			String resource = "/com/coffee/config/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	// 全局工厂
	public static SqlSessionFactory getFactory()
	{
		return 	factory;
	}	
}
