<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<style>
		/* 表格样式 */
		table{
			border-collapse: collapse; /* 边线收缩 */
			table-layout: fixed ;  /* 自动布局还是固定宽度 */
			word-break: break-all; /* 换行设定 */
			word-wrap:break-word;  /* 换行折断设定 */
		}
		
		/* 逗号表示同时指定多个目标的样式 */
		table,td,th{
			border: 1px solid #888;
			padding: 4px;
		}

		.row{
			margin: 10px 0;
		}
	</style>
<body>
	<div style='width:500px;margin:40px auto auto auto' >
  	<div class='row'> 当前用户: <%=session.getAttribute("user") %>  </div>
  		<div class='row'> 查询结果 </div>
  		
    	<table>
    		<tr>
    			<th style='width:80px'> 学号 </th>
    			<th style='width:120px'> 姓名 </th>
    			<th style='width:60px'> 性别 </th>
    			<th> 手机号 </th>
    		</tr>
    		<tr>
    		<c:forEach  items="${studentList}"  
    		var="stu"  varStatus="stuStatus"> 
			<tr> 
				<td> ${stu.id} </td>
				<td> ${stu.name}</td>
				<td> ${stu.sex}</td>
				<td> ${stu.phone}</td>
			</tr>
		   	 </c:forEach>
    	</table>

    </div>
</body>
</html>