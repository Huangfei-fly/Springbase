<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
 <title> 学生信息 </title>
	
    <meta charset='utf-8'> 
	
	<style>
		.row{
			margin: 10px 0;
		}
	</style>
<body>

  	<div style='width:500px;margin:40px auto auto auto' >
    <div class='row'> info1</div>
  		<div class='row'> 学生信息 :</div>
    
    	<div class='row'> 学号: ${stu.id} </div>
     	<div class='row'> 姓名:  ${stu.name} </div>
     	<div class='row'> 性别:  ${stu.sex} </div>
     	<div class='row'> 手机号: ${stu.phone} </div>
    </div>
</body>
</html>