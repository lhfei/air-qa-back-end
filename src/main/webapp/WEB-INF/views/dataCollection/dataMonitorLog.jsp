<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>检测数据采集日志</title>
<%@ include file="../commons/taglib.jsp"%>
</head>
<body>
	<table class="easyui-datagrid" style="width: 700px; height: 250px"
		data-options="fit:true,singleSelect:true,url:'datagrid_data1.json',method:'post',toolbar:'#tb'">
		<thead>
			<tr>
				<th data-options="field:'itemid',width:80">流水号</th>
				<th data-options="field:'listprice',width:100">终端ID</th>
				<th data-options="field:'unitcost',width:150">日期</th>
				<th data-options="field:'attr1',width:150">时间</th>
				<th data-options="field:'attr1',width:150">PM2.5</th>
				<th data-options="field:'attr1',width:150">甲醛</th>
				<th data-options="field:'attr1',width:150">其他</th>
				<th data-options="field:'attr1',width:150">当前日期</th>
				<th data-options="field:'status',width:60,align:'center'">当前时间</th>
			</tr>
		</thead>
	</table>

	<div id="tb" style="padding: 5px; height: auto">
		<div style="margin-bottom: 5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true">增加</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit"plain="true">删除</a> 
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit"plain="true">导入Excel</a> 
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit"plain="true">导出Excel</a> 
		</div>
		<div>
			流水号：<input type="text">
			终端ID：<input type="text">
			PM2.5：<input type="text">
			<a href="#" class="easyui-linkbutton"  plain="true">查询</a>
		</div>
	</div>
	
	<div id="dlg" class="easyui-dialog" title="新增终端绑定" style="width:450px;height:200px;padding:10px">
         <table>
         	<tr>
         		<td>终端ID</td>
         		<td><input type="text"></td>
         		<td></td>
         		<td></td>
         	</tr>
          	<tr>
         		<td>开始日期</td>
         		<td style="padding-left: 3px"><input class="easyui-datebox"></input></td>
         		<td>结束日期</td>
         		<td><input class="easyui-datebox"></input></td>
         	</tr>
         	<tr>
         		<td>备注</td>
         		<td colspan="3"><textarea rows="4" cols="48"></textarea></td>
         	</tr>
         </table>
    </div>
</body>
</html>
