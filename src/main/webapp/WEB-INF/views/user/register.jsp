<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>用户注册</title>
<%@ include file="../commons/taglib.jsp"%>
<style type="text/css">
table {
	margin: 0 auto;
}

table #btn_td {
	text-align: center;
}
</style>
</head>
<body>
	<form action="./registerForm" method="post" name="registerform">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>邮箱：</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;码：</td>
				<td><input type="password" name="password">
			</tr>
			<tr>
				<td>密码确认：</td>
				<td><input type="rePassword" name="rePassword"></td>
			</tr>
			<tr>
				<td id="btn_td" colspan="2"><input type="submit" value="保存">
					<input type="button" value="取消" onclick="cancelRegister()"></td>
			</tr>
			<tr>
				<td colspan="2"><span style="color: red;">${register_msg}</span></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
	function cancelRegister() {
		window.location.href = "./";
	}
</script>
</html>
