package com.coffee.a6;

import java.util.ArrayList;
import java.util.List;

import com.coffee.entity.Student;

/** 
 * 全局实例两种创建方式
 * 1、直接使用public static
 * 2、在配置文件创建<bean>
 */
public class DemoDB
{	//方法1
	//public static DemoDB instance = new DemoDB();
	
	//////////////////////////
	private List<Student> list = new ArrayList<>();
		
	public DemoDB()
	{
		System.out.println("DemoDB实例创建！");
		init();
	}
	
	public void init()
	{
		list.add(new Student(20200001, "刘伟", true, "13810000001"));
		list.add(new Student(20200002, "关羽", false, "1282000101"));
		list.add(new Student(20200003, "张飞", false, "13653464356"));
		list.add(new Student(20200004, "赵云", true, "13226245325"));
		list.add(new Student(20200005, "刘备", true, "13676867865"));
		list.add(new Student(20200006, "吕布", true, "13878685678"));
		list.add(new Student(20200007, "貂蝉", false, "13834512345"));
		list.add(new Student(20200008, "夏侯惇", false, "13456746766"));
		list.add(new Student(20200009, "曹操", true, "13523456788"));
		list.add(new Student(20200010, "曹植", false, "18723452345"));
		list.add(new Student(20200011, "华佗", true, "13876789978"));
	}

	public List<Student> getList()
	{
		return list;
	}
}
