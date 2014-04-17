<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>终端绑定</title>
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
	width: 80px;
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

.queryTable textarea{
	height:45px;
	overflow:hidden;
	border: 1px solid #cccccc;
}

textarea:hover{
	height:45px;
	overflow:hidden;
	border: 1px solid #0066CC;
}

#btn_td input:hover{
	height:24px;
	width:50px;
	border: 1px solid #cccccc;
}	

</style>
</head>
<body>
	<table class="easyui-datagrid" style="width: 700px; height: 250px"
		data-options="fit:true,singleSelect:true,url:'datagrid_data1.json',method:'post',toolbar:'#tb'">
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
	
	<div id="dlg" class="easyui-dialog" title="新增终端绑定" style="width:500px;height:200px;padding:10px">
         <table class="queryTable">
         	<tr>
         		<th>终端ID</th>
         		<td><input type="text"></td>
         		<th></th>
         		<td></td>
         	</tr>
          	<tr>
         		<th>开始日期</th>
         		<td style="padding-left: 3px"><input class="easyui-datebox"></input></td>
         		<th>结束日期</th>
         		<td><input class="easyui-datebox"></input></td>
         	</tr>
         	<tr>
         		<th>备注</th>
         		<td colspan="3"><textarea rows="4" cols="48"></textarea></td>
         	</tr>
         </table>
    </div>
</body>
</html>
