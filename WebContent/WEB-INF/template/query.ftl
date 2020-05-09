<!DOCTYPE html>
<html>
  <head>
    <title> 查询结果 </title>
	
    <meta charset='utf-8'> 
	
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
  </head>
  
  <body>
  	<div style='width:500px;margin:40px auto auto auto' >
  	<div class='row'> 当前用户: ${Session.user !"未登录" }  </div>
  	<div class='row'> freemarker解析</div>
  		<div class='row'> 查询结果 </div>
  		
    	<table>
    		<tr>
    			<th style='width:80px'> 学号 </th>
    			<th style='width:120px'> 姓名 </th>
    			<th style='width:60px'> 性别 </th>
    			<th> 手机号 </th>
    		</tr>
    		<tr>
    		
   			<#list studentList as stu>
			<tr> 
				<td> ${stu.id?c} </td>
				<td> ${stu.name}</td>
				<td> ${stu.sex?c}</td>
				<td> ${stu.phone}</td>
			</tr>
			</#list>    	
    	</table>

    </div>
    
  </body>
</html>
