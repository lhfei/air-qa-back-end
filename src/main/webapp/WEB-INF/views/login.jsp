<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>用户登录</title>
<style type="text/css">
.queryTable{
	width:300px;
	border: 0px solid #cccccc;
	padding:0; 
	margin:0 0;
	border-collapse: collapse;
}
.queryTable tr{
	height: 30px;
}

.queryTable th{
	font-weight: normal;
}

.queryTable td {
	align:center;
	border: 0px solid #cccccc;
	background: #fff;
	font-size:12px;
	padding: 3px 3px 3px 3px;
	color: #000;
	padding: 0px;
}

.queryTable input{
	height:20px;
	width:150px;
	border: 1px solid #cccccc;
}

input:hover{
	height:20px;
	width:150px;
	border: 1px solid #0066CC;
}

#btn_td input{
	height:24px;
	width:50px;
	border: 1px solid #cccccc;
}
#btn_td input:hover{
	height:24px;
	width:50px;
	border: 1px solid #cccccc;
}
</style>
</head>
<body>
	<div align="center">
	<form action="./loginForm" method="post" name="loginform">
		<table class="queryTable">
			<tr>
				<th>邮&nbsp;&nbsp;箱：</th>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<th>密&nbsp;&nbsp;码：</th>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td id="btn_td" colspan="2">
					<input type="submit" value="登录">&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="注册" onclick="register()"></td>
			</tr>
		</table>
	</form>
	</div>
</body>
<script type="text/javascript">
	function register() {
		window.location.href = "./register";
	}
</script>
</html>
