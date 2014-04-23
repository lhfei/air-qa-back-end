<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Home</title>

<%@ include file="commons/taglib.jsp"%>
<link rel="stylesheet" type="text/css" href="${basePath}/resources/css/home.css">
<link rel="stylesheet" type="text/css" href="${basePath}/resources/css/selfTree.css">
<style type="text/css">
#title {
	font-size: 18px;
	font-weight: bold;
	padding: 5px 10px;
	background: #336699;
	color: #fff;
	height: 60%
}
a{
	text-decoration: none;
}
a:VISITED {
	font-weight: bold;
	color: #006600;
}
</style>
<script type="text/javascript">
	

</script>
</head>
<body class="easyui-layout">
	<div id="title" data-options="region:'north'" style="height: 40px;">
		国家室内车内空气监测中心后台系统</div>
	<div data-options="region:'west',title:'主菜单',split:true" style="width: 180px;">
		<ul class="easyui-tree" data-options="url:'${basePath}//resources/json/tree_menu.json',onClick:addTab"></ul>
	</div>
	<div data-options="region:'center'">
		<div id="tabs" class="easyui-tabs" data-options="fit:true"></div>
	</div>
	<div data-options="region:'south'" style="height:25px;">
    	<div style="text-align: center;">国家室内车内空气监测中心-中国室内环境网</div>
    </div>
</body>
<script type="text/javascript">

$(function(){
});

function addTab(node){
	var flag = $('#tabs').tabs('exists',node.text);
	
	if(flag){
		$('#tabs').tabs('select', node.text);
		//刷新面板
		var tab = $('#tabs').tabs('getSelected');  
		tab.panel('refresh');
		
		return;
	}
	
	$('#tabs').tabs('add', {
		title: node.text,
		content: '<iframe src="${basePath}/'+node.attributes.url+'" scrolling="no" frameborder="0" style="width: 100%; height: 99.6%; padding: 0px;"></iframe>',
		closable:true
	});
}

</script>
</html>
