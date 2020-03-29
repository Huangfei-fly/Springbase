package com.coffee.a2;

import java.util.ArrayList;
import java.util.List;

import com.coffee.entity.Student;

/** DemoDB: 模拟一个数据源
 * 
 */
public class DemoDB
{	
	public static List<Student> list = new ArrayList<Student>();
		
	static{
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
}
