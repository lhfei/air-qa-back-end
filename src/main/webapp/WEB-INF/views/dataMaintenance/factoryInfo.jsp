<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>厂家信息维护</title>
<%@ include file="../commons/taglib.jsp"%>
</head>
<body>
	<table id="dg" class="easyui-datagrid" style="width: 700px; height: 250px"
		data-options="fit:true,singleSelect:true,url:'${basePath}/company/findCompany',method:'post',pagination:true,toolbar:'#tb'">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'companyId',width:80">厂家ID</th>
				<th data-options="field:'companyTitle',width:100">名称</th>
				<th data-options="field:'contact',width:100">联系人</th>
				<th data-options="field:'phone',width:150">电话</th>
				<th data-options="field:'email',width:150">邮箱</th>
				<th data-options="field:'province',width:150">省</th>
				<th data-options="field:'city',width:150">市</th>
				<th data-options="field:'county',width:150">县区</th>
				<th data-options="field:'address',width:150">地址</th>
			</tr>
		</thead>
	</table>

	<div id="tb" style="padding: 5px; height: auto">
		<div style="margin-bottom: 5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addFactory()">增加</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="updateFactory()">更新</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit"plain="true" onclick="deleteFactory()">删除</a> 
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit"plain="true">Excel导入</a> 
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit"plain="true">Excel导出</a> 
		</div>
	</div>
	
	<div id="dlg" class="easyui-dialog" title="编辑厂家信息" data-options="closed:true,onClose:clearForm" style="width:450px;height:280px;padding:10px">
		<form id="ff" method="post">
			<input type="hidden" name="companyId" value="0">
         <table>
         	<tr>
         		<td>名称</td>
         		<td><input type="text" name="companyTitle"></td>
         		<td>联系人</td>
         		<td><input type="text" name="contact"></td>
         	</tr>
          	<tr>
         		<td>电话</td>
         		<td><input type="text" name="phone"></td>
         		<td>邮箱</td>
         		<td><input type="text" name="email"></td>
         	</tr>
         	<tr>
         		<td>省：</td>
				<td style="padding-left: 2px">
					<select id="province" class="easyui-combobox" name="province" style="width: 153px;"></select>
				</td>
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
         		<td>地址</td>
         		<td colspan="3"><textarea name="address" rows="4" cols="48"></textarea></td>
         	</tr>
         	<tr>
				<td id="btn_td" colspan="4" style="text-align: center;">
					<input type="submit" value="保存">
					<input type="button" value="关闭" onclick="closeDig();">
				</td>
			</tr>
         </table>
        </form>
    </div>
    
    <!--数据上传对话框  -->
    <div id="upload_dlg" class="easyui-dialog" title="厂家信息Excel导入" data-options="closed:true,onClose:clearForm" style="width:450px;height:280px;padding:10px">
    	<form id="upload_form" action="${basePath}/uploadData/dataUp" method="post" enctype="multipart/form-data" >
	      		 <input type="file" name="file" id="file"  size="35px">
	      		 <input type="submit" name="sub" value="上传" onclick="Upload()"/>
		 </form>
    </div>
    
    <script type="text/javascript">
    
    	$(function(){
    		$('#ff').form({
    		    url:"${basePath}/company/saveFactoryInfo",
    		    onSubmit: function(){
    		    	
    		    },
    		    success:function(data){
    		    	if(data){
    		    		$.messager.alert('工厂信息','工厂信息更新成功!');
    		    		closeDig();
    		    	}
    		    	
    		    }
    		});
    		
    		$("#province").combobox({valueField:'name',textField:'name',url:"${basePath}/region/findRegion?level=1&pid=0",onSelect:selectCity});
    	});
    	
    	function selectCity(record){
    		$("#city").combobox({valueField:'name',textField:'name',url:"${basePath}/region/findRegion?level=2&pid="+record.id,onSelect:selectcounty});
    	}
    	
    	function selectcounty(record){
    		$("#county").combobox({valueField:'name',textField:'name',url:"${basePath}/region/findRegion?level=3&pid="+record.id});
    	}
    
    	function addFactory(){
    		$('#dlg').dialog('open');
    	}
    	
    	function updateFactory(){
    		var obj=$('#dg').datagrid('getChecked');
    		$('#ff').form('load',obj[0]);
    		$('#dlg').dialog('open');
    		
    	}
    	
    	function deleteFactory(){
    		  $.messager.confirm('工厂信息', '你确定要删除当前工厂信息吗?', function(r){
                  if (r){
                	  var obj=$('#dg').datagrid('getChecked');
              		  var companyId=obj[0].companyId;
                	  $.post("${basePath}/company/deleteFactoryInfo", {companyId:companyId},
             				function(data){
             	    			if(data){
             			    		$.messager.alert('工厂信息','工厂信息删除成功!');
             			    		$('#dg').datagrid('reload');
             			    	}
             				});
                  }
              });
    	}
    	
    	function clearForm(){
    		$('#ff').form('clear');
    	}
    	
    	function closeDig(){
    		clearForm();
    		$('#dlg').dialog('close');
    		$('#dg').datagrid('reload');
    	}
    
    </script>
</body>
</html>
