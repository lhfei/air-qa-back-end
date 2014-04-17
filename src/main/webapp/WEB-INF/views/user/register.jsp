<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>用户注册</title>
<%@ include file="../commons/taglib.jsp"%>
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
	<form action="./registerForm" method="post" name="registerform">
		<table class="queryTable">
			<tr>
				<td>用&nbsp;&nbsp;户&nbsp;&nbsp;名：</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
				<td><input type="password" name="password">
			</tr>
			<tr>
				<td>密码确认：</td>
				<td><input type="password" name="rePassword"></td>
			</tr>
			<tr>
				<td id="btn_td" colspan="2"><input type="submit" value="保存">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="取消" onclick="cancelRegister()"></td>
			</tr>
			<tr>
				<td colspan="2"><span style="color: red;">${register_msg}</span></td>
			</tr>
		</table>
	</form>
</div>
</body>
<script type="text/javascript">
	function cancelRegister() {
		window.location.href = "./";
	}
</script>
</html>
