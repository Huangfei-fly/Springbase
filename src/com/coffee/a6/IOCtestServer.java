package com.coffee.a6;

public class IOCtestServer {
	private String ip;
	private int port;
	
	public IOCtestServer()
	{
		System.out.println("** 创建 IOCtest 实例 ...");
	}
	
	// 启动服务器
	public void start()
	{	
		System.out.println("** 模拟启动 IOCtest...@" + ip + ":" + port);
		
	}

	public String getIp()
	{
		return ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	public int getPort()
	{
		return port;
	}

	public void setPort(int port)
	{
		this.port = port;
	}
}
