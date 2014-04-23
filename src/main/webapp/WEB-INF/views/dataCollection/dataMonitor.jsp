<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>检测数据导入</title>
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
				<th data-options="field:'attr1',width:150">时间时间</th>
				<th data-options="field:'attr1',width:150">采集状态</th>
				<th data-options="field:'status',width:60,align:'center'">备注</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding: 5px; height: auto">
		<div style="margin-bottom: 5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true">导出Excel</a>
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
