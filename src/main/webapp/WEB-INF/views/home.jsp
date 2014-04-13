<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Home</title>
<%@ include file="commons/taglib.jsp"%>
<style type="text/css">
#title {
	font-size: 18px;
	font-weight: bold;
	padding: 5px 10px;
	background: #336699;
	color: #fff;
	height: 60%
}
</style>
</head>
<body class="easyui-layout">
	<div id="title" data-options="region:'north'" style="height: 40px;">
		国家室内车内空气监测中心后台系统</div>
	<div data-options="region:'west',title:'菜单',split:true"
		style="width: 180px;">
		<ul class="easyui-tree">
			<li data-options="state:'open'"><span>用户管理</span>
				<ul>
					<li><a href="${basePath}/login" target="centFra">用户登录</a></li>
					<li><a>个人信息维护</a></li>
					<li><a>终端绑定</a></li>
					<li><a>账户管理</a></li>
				</ul></li>
			<li><span>主数据维护</span>
				<ul>
					<li>厂家信息维护</li>
					<li>终端信息维护</li>
					<li>客户信息维护</li>
					<li>终端绑定管理</li>
				</ul></li>
		</ul>
	</div>
	<div data-options="region:'center'">
		<iframe name="centFra" scrolling="no" frameborder="0"  style="width:100%;height:99.5%;padding: 0px;"></iframe>
	</div>
	<div data-options="region:'south'" style="height:25px;">
    	<div style="text-align: center;">国家室内车内空气监测中心-中国室内环境网</div>
    </div>
</body>

</html>
