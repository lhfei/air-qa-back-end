<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>用户登录</title>
<style type="text/css">
table {
	margin: 0 auto;
}

table #btn_td{
	text-align: center;
}
</style>
</head>
<body>
	<form action="./login" method="post" name="loginform">
		<table>
			<tr>
				<td>邮箱：</td>
				<td><input type="text" name="email" value="gxpt"></td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;码：</td>
				<td><input type="password" name="password" value="123456"></td>
			</tr>
			<tr>
				<td id="btn_td" colspan="2"><input type="submit" value="登录"><input
					type="button" value="注册" onclick="register()"></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
	function register() {
		window.location.href = "./register";
	}
</script>
</html>
