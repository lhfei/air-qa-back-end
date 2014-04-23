<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>个人信息维护</title>
<%@ include file="../commons/taglib.jsp"%>
<style type="text/css">
table {
	margin: 0 auto;
}

td {
	padding: 0px;
}

table #btn_td {
	text-align: center;
}
</style>
</head>
<body>
	<form id="ff" method="post">
		<input type="hidden" name="userId" value="${user.userId}">
		<table class="layoutTab">
			<tr>
				<td>姓名：</td>
				<td><input type="text" name="userName" value="${user.userName}"></td>
			</tr>
				<tr>
				<td>性别：</td>
				<td style="padding-left: 2px">
					<select name="gender" style="width: 153px;">
						<option value="1">男</option>
						<option value="0">女</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>身份证号：</td>
				<td><input type="text" name="idCard" value="${user.idCard}"></td>
			</tr>
			<tr>
				<td>手机：</td>
				<td><input type="text" name="mobile" value="${user.mobile}"></td>
			</tr>
			<tr>
				<td>省：</td>
				<td style="padding-left: 2px">
					<select id="province" class="easyui-combobox" name="province" style="width: 153px;"></select>
					
				</td>
			</tr>
			<tr>
				<td>市：</td>
				<td style="padding-left: 2px">
					<select id="city" class="easyui-combobox" name="city" data-options="" style="width: 153px;"></select>
				</td>
			</tr>
			<tr>
				<td>县：</td>
				<td style="padding-left: 2px">
					<select id="county" class="easyui-combobox" name="county" style="width: 153px;"></select>
				</td>
			</tr>
			<tr>
				<td>街道/乡镇：</td>
				<td><input type="text" name="zone" value="${user.zone}"></td>
			</tr>
			<tr>
				<td>房间/门牌号：</td>
				<td><input type="text" name="houseNumber" value="${user.houseNumber}"></td>
			</tr>
			<tr>
				<td>微信昵称/ID：</td>
				<td><input type="text" name="userAlias" value="${user.userAlias}"></td>
			</tr>
			<tr>
				<td id="btn_td" colspan="2"><input type="submit" value="保存">
			</tr>
		</table>
	</form>
<script type="text/javascript">

	$(function(){
		$('#ff').form({
		    url:"${basePath}/user/userInfoForm",
		    onSubmit: function(){
		        
		    },
		    success:function(data){
		    	if(data){
		    		$.messager.alert('个人信息','个人信息更新成功!');
		    	}
		    	
		    }
		});
		
		$("#province").combobox({valueField:'name',textField:'name',url:"${basePath}/region/findRegion?level=1&pid=0",onSelect:selectCity});
		
		//初始化显示省，市，县的值
		$('#province').combobox('setValue', '${user.province}');
		$('#city').combobox('setValue', '${user.city}');
		$('#county').combobox('setValue', '${user.county}');
	});

	function selectCity(record){
		$("#city").combobox({valueField:'name',textField:'name',url:"${basePath}/region/findRegion?level=2&pid="+record.id,onSelect:selectcounty});
	}
	
	function selectcounty(record){
		$("#county").combobox({valueField:'name',textField:'name',url:"${basePath}/region/findRegion?level=3&pid="+record.id});
	}
	
	
</script>
</body>
</html>
