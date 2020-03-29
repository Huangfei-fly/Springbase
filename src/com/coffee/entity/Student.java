package com.coffee.entity;

public class Student
{
	private int id;
	private String name;
	private boolean sex; 
	private String phone;
	
	
	public Student()
	{		
	}
	public Student(int id, String name, boolean sex, String phone)
	{
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
	}
	
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	
	
}
