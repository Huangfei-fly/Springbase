package com.coffee.a10.fastjson.a1;

public class Student
{
	public int id;
	public String name;
	public boolean sex;
	public String phone;
	public int[] score;
	
	public Student()
	{
		
	}
	
	public Student(int id, String name, boolean sex, String cellphone)
	{
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.phone = cellphone;
		this.score=new int[] {10,20,30};
	}
//////////////////////////////
	
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

	public boolean isSex()
	{
		return sex;
	}

	public void setSex(boolean sex)
	{
		this.sex = sex;
	}

	public String getCellphone()
	{
		return phone;
	}

	public void setCellphone(String cellphone)
	{
		this.phone = cellphone;
	}

	public int[] getScore()
	{
		return score;
	}

	public void setScore(int[] score)
	{
		this.score = score;
	}
	
	
	
}
