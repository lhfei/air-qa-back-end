<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>用户管理</title>
<%@ include file="../commons/taglib.jsp"%>
</head>
<body>
	<table class="easyui-datagrid" style="width: 700px; height: 250px"
		data-options="fit:true,singleSelect:true,url:'datagrid_data1.json',method:'post',toolbar:'#tb'">
		<thead>
			<tr>
				<th data-options="field:'itemid',width:80">客户ID</th>
				<th data-options="field:'productid',width:100">邮箱</th>
				<th data-options="field:'listprice',width:100">密码</th>
				<th data-options="field:'unitcost',width:150">锁定</th>
				<th data-options="field:'status',width:60,align:'center'">备注</th>
			</tr>
		</thead>
	</table>

	<div id="tb" style="padding: 5px; height: auto">
		<div style="margin-bottom: 5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true">增加</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true">删除</a> 
		</div>
		<div style="margin-bottom: 5px">
			客户ID：<input type="text"> 客户邮箱：<input type="text"><a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true">查询</a>
		</div>
	</div>
	
	<div id="dlg" class="easyui-dialog" title="新增终端绑定" style="width:450px;height:200px;padding:10px">
         <table>
         	<tr>
         		<td>客户ID</td>
         		<td><input type="text"></td>
         		<td>客户邮箱</td>
         		<td><input type="text"></td>
         	</tr>
          	<tr>
         		<td>密码</td>
         		<td><input type="text"></input></td>
         		<td>锁定</td>
         		<td><select class="easyui-combobox"></select></td>
         	</tr>
         	<tr>
         		<td>备注</td>
         		<td colspan="3"><textarea rows="4" cols="48"></textarea></td>
         	</tr>
         </table>
    </div>
</body>
</html>
