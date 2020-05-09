package com.coffee.a14.util;

/**
 * 通用的异常类,带 error和reason两个属性
 *
 */
public class SpringException extends RuntimeException
{
	public int error = -1;
	public String reason = "";
	
	public SpringException()
	{		
	}
	public SpringException( int error)
	{	
		this.error = error;
	}
	public SpringException( String reason)
	{	
		this.reason = reason;
	}
	public SpringException(int error, String reason)
	{
		this.error = error;
		this.reason = reason;
	}
	
	@Override
	public String getMessage()
	{
		return reason + "(" + error + ")";
	}
	
	
}
