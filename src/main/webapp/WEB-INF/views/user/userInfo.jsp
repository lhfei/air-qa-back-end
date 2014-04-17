<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>个人信息维护</title>
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
	<form action="./login" method="post" name="loginform">
		<table class="queryTable">
			<tr>
				<td>姓名：</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>身份证号：</td>
				<td><input type="text" name="idCard"></td>
			</tr>
			<tr>
				<td>手机：</td>
				<td><input type="text" name="idCard"></td>
			</tr>
			<tr>
				<td>省：</td>
				<td style="padding-left: 2px"><select class="easyui-combobox" name="state"
					style="width: 153px;"></select></td>
			</tr>
			<tr>
				<td>市：</td>
				<td style="padding-left: 2px"><select class="easyui-combobox" name="state"
					style="width: 153px;"></select></td>
			</tr>
			<tr>
				<td>县：</td>
				<td style="padding-left: 2px"><select class="easyui-combobox" name="state"
					style="width: 153px;"></select></td>
			</tr>
			<tr>
				<td>街道/乡镇：</td>
				<td><input type="text" name="idCard"></td>
			</tr>
			<tr>
				<td>房间/门牌号：</td>
				<td><input type="text" name="idCard"></td>
			</tr>
			<tr>
				<td>微信昵称/ID：</td>
				<td><input type="text" name="idCard"></td>
			</tr>
			<tr>
				<td id="btn_td" colspan="2"><input type="submit" value="保存">
			</tr>
		</table>
	</form>
	</div>
</body>
</html>
