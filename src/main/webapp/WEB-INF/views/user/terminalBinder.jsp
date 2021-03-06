<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>终端绑定</title>
<%@ include file="../commons/taglib.jsp"%>
</head>
<body>
	<table class="easyui-datagrid" style="width: 700px; height: 250px"
		data-options="fit:true,pagination:true,singleSelect:true,method:'post',toolbar:'#tb'">
		<thead>
			<tr>
				<th data-options="field:'itemid',width:80">流水号</th>
				<th data-options="field:'productid',width:100">客户</th>
				<th data-options="field:'listprice',width:100">终端</th>
				<th data-options="field:'unitcost',width:150">开始时间</th>
				<th data-options="field:'attr1',width:150">结束时间</th>
				<th data-options="field:'status',width:60,align:'center'">备注</th>
			</tr>
		</thead>
	</table>

	<div id="tb" style="padding: 5px; height: auto">
		<div style="margin-bottom: 5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true">增加</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit"plain="true">删除</a> 
		</div>
	</div>
	
	<div id="dlg" class="easyui-dialog" title="新增终端绑定" style="width:480px;height:250px;padding:10px">
		<form>
		<input type="hidden" name="userId" value="${user.userId}">
         <table>
         	<tr>
         		<td>用户</td>
         		<td><input type="text" name="userName" value="${user.userName}" readonly></td>
         		<td>终端ID</td>
         		<td><input type="text"></td>
         	</tr>
          	<tr>
         		<td>开始日期</td>
         		<td><input class="easyui-datebox"></input></td>
         		<td>结束日期</td>
         		<td><input class="easyui-datebox"></input></td>
         	</tr>
         	<tr>
         		<td>备注</td>
         		<td colspan="3"><textarea rows="4" cols="48"></textarea></td>
         	</tr>
         	<tr>
         		<td colspan="4" style="text-align: center;">
         			<a href="#" class="easyui-linkbutton" >保存</a>
					<a href="#" class="easyui-linkbutton" >取消</a>
				</td>
         	</tr>
         </table>
         </form>
    </div>
</body>
</html>
