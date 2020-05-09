<!DOCTYPE html>
<html>
  <head>
    <title>hello.html</title>
	
    <meta charset='utf-8'> 
	
	<style>
		.row{
			margin: 10px 0;
		}
	</style>
  </head>
  
  <body >
  	<div style='width:500px;margin:40px auto auto auto' >
    <div class='row'> freemarker解析</div>
  		<div class='row'> 学生信息 :</div>
    
    	<div class='row'> 学号: ${stu.id?c} </div>
     	<div class='row'> 姓名:  ${stu.name} </div>
     	<div class='row'> 性别:  ${stu.sex?c} </div>
     	<div class='row'> 手机号: ${stu.phone} </div>
    </div>
    
  </body>
</html>
