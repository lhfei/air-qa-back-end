<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>检测申请</title>
<%@ include file="../commons/taglib.jsp"%>
<link rel="stylesheet" type="text/css" href="${basePath}/resources/css/selfTree.css"/>
<link rel="stylesheet" type="text/css" href="${basePath}/resources/commonjs/My97DatePicker/skin/blue/datepicker.css"/>
<script type="text/javascript" src="${basePath}/resources/commonjs/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${basePath}/resources/appjs/applyingCheck.js"></script>
<style type="text/css">
body{
	overflow: hidden;
}
#title {
	font-size: 18px;
	font-weight: bold;
	padding: 5px 10px;
	background: #336699;
	color: #fff;
	height: 60%
}

a {
	text-decoration: none;
}

a:VISITED {
	font-weight: bold;
	color: #006600;
}

.queryTable{
	width:580px;
	border: 0px solid #cccccc;
	padding:0; 
	margin:0 0;
	border-collapse: collapse;
}
.commonTable {
	width:580px;
	border: 1px solid #cccccc;
	padding:0; 
	margin:0 auto;
	border-collapse: collapse;
}

.scrollTable { height: 125px; overflow-x: hidden; overflow-y: auto;margin:0px; width: 100%; }

.commonTable th {
	border: 1px solid #cccccc;
	background: #fff;
	font-size:12px;
	font-weight:normal;
	padding: 3px 3px 3px 8px;
	color: #000;
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

.commonTable td {
	align:center;
	border: 1px solid #cccccc;
	background: #fff;
	font-size:12px;
	padding: 3px 3px 3px 3px;
	color: #000;
	padding: 0px;
}

.buttontd{
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
	border: 1px solid #cccccc;
}

.commonTable input{
	height:20px;
	border: 1px solid #FFF;
}

.queryTable textarea{
	height:45px;
	overflow:hidden;
	border: 1px solid #cccccc;
}

input:hover{
	height:18px;
	border: 1px solid #0066CC;
}

.commonTable textarea{
	height:45px;
	overflow:hidden;
	border: 1px solid #FFF;
}

textarea:hover{
	height:45px;
	overflow:hidden;
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
<script type="text/javascript">
/**
 * 动态添加指标值行
 */
function addTableRow(){
	var table = $("#qaKpiTable");
	var tr=$("<tr></tr>");
	tr.appendTo($(table)); 
	var type = "";
	$.each(contentArr,function(i,data){
		var td= "";
		if(i == 0){
			td = $("<td><input type='hidden' name='qaKpiBos["+kpiRowCount+"].kpiId'/>"+
					"<input type='hidden' name='qaKpiBos["+kpiRowCount+"].kpiValue'/>"+
					"<input type='hidden' name='qaKpiBos["+kpiRowCount+"].recordId'/>"+
					"<input type='text' name='qaKpiBos["+kpiRowCount+"]."+data.attrname+"'/></td>");
		}else{
			td = $("<td><input type='text' name='qaKpiBos["+kpiRowCount+"]."+data.attrname+"'/></td>");
		}
		td.appendTo(tr);
	});
	var operatetd=$("<td width='80'><img alt='' style='cursor:pointer;' title='保存' onclick='saveTableRow(this)' src='${basePath}/resources/themes/icons/ok.png'/>"+
			"&nbsp;&nbsp;&nbsp;&nbsp;<img alt='' style='cursor:pointer;' title='删除' onclick='removeTableRow(this)' src='${basePath}/resources/themes/icons/edit_remove.png'/></td>");
	operatetd.appendTo(tr);
	kpiRowCount++;
}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'west',title:'检测范围',split:true,fit:false"
		style="width: 180px;">
		<ul class="easyui-tree">
			<li><a>家庭检测</a></li>
			<li><a>建筑工程检测</a></li>
			<li><a>终端绑定</a></li>
			<li><a>车内环境检测</a></li>
		</ul> 
	</div>
	<div id="centerArea" data-options="region:'center'" style="text-align:left;" onresize="resizeDiv('centerArea')">
		<h4 align="center">家庭检测申请记录</h4>
		<div align="left" style="overflow: hidden;">
			<table class="queryTable">
				<tr>
					<td>
						<span>检测单号</span>
					</td>
					<td>
						<input/>
					</td>
					<td>
						<span>客户名称</span>
					</td>
					<td>
						<input/>
					</td>
					<td class="buttontd">
						<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
						<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-undo'">清除</a>
					</td>
				</tr>
			</table>
			<br>
			<table id="recordList" data-options="rownumbers:true,fitColumns:true,singleSelect:true,
				autoRowHeight:false,pagination:true,pageSize:10,toolbar:'#toolsButton'" >
				<thead>
				<tr>
					<th field="recordNum" width="80">检测单号</th>
					<th field="type" width="100">业务类别</th>
					<th field="agent" width="80">客户</th>
					<th field="operatedTime" width="120">检测时间</th>
					<th field="phase" width="80">状态</th>
				</tr>
				</thead>
			</table>
			<div id="toolsButton">
				<a href="#" class="easyui-linkbutton" onclick="addData();" data-options="iconCls:'icon-add'">新增</a>
				<a href="#" class="easyui-linkbutton" onclick="editData();" data-options="iconCls:'icon-edit'">修改</a>
				<a href="#" class="easyui-linkbutton" onclick="viewData();" data-options="iconCls:'icon-tip'">查看</a>
				<a href="#" class="easyui-linkbutton" onclick="exportData();" data-options="iconCls:'icon-undo'">导出EXCEL</a>
			</div>
		</div>
	</div>
	<div id="dataFormDiv" class="easyui-dialog" title="家庭检测申请" data-options="iconCls:'icon-save',closed:'true'">
		<form method="post" action="./createCheck" id="applyingCheckForm" name="applyingCheckForm">
		<table class="commonTable">
			<tr>
				<th><span>检测单号</span></th>
				<td><input name="recordNum" readonly="readonly" type="text"/></td>
				<th><span>委托单位/人</span></th>
				<td><input name="agent" type="text"/></td>
			</tr>
			<tr>
				<th><span>联系人</span></th>
				<td><input name="contact" type="text"/></td>
				<th><span>联系电话</span></th>
				<td><input name="phone" type="text"/></td>
			</tr>
			<tr height="30px">
				<th height="30px"><span>通信地址</span></th>
				<td height="30px"><textarea name="address" rows="" cols=""></textarea></td>
				<th height="30px"><span>检测地址</span></th>
				<td height="30px"><textarea name="location" rows="" cols=""></textarea></td>
			</tr>
			<tr>
				<th><span>检测时间</span></th>
				<td><input name="operatedTime" readonly="readonly" type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"/></td>
				<th><span>检测费用（元）</span></th>
				<td><input name="cost" type="text"/></td>
			</tr>
			<tr>
				<th><span>状态</span></th>
				<td><input name="phase" type="text"/></td>
				<th><span>缴费</span></th>
				<td>
					<label><input type="radio" name="paid" value="0" /> 是</label>
					<label><input type="radio" name="paid" value="1" /> 否</label>
				</td>
			</tr>
		</table>
		<!--  </form>
		<br/>
		<form method="post" action="./createQaKpiList" id="qaKpiForm" name="qaKpiForm">-->
		<table id="kpiParentTable" class="commonTable">
			<tr>
				<th width="155">
					<span style="float: left;">检测项目</span>
					<div style="margin:0px;float: right;">
						<img alt="" style="cursor:pointer;" title="新增" onclick="addTableRow()" src="${basePath}/resources/themes/icons/edit_add.png"/>
					</div>
				</th>
				<th width="155"><span>编码</span></th>
				<th width="155"><span>备注</span></th>
				<th><span>操作</span></th>
			</tr>
			<tr>
				<td colspan="4">
					<div class="scrollTable">
						<table id="qaKpiTable" class="commonTable">
							
						</table>
					</div>;
				</td>
			</tr>
		</table>
		<div align="center" id="btn_td" style="margin: 20px;">
			 <a href="#" id="saveBtn" class="easyui-linkbutton" onclick="saveData();" data-options="iconCls:'icon-ok'">保存</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="#" id="cancelBtn" class="easyui-linkbutton" data-options="iconCls:'icon-undo'">返回</a>
			<!--<input type="submit" value="登录">
			<input type="button" value="注册" onclick="clearData()"> -->
		</div>
		</form>
	</div>
</body>
</html>


