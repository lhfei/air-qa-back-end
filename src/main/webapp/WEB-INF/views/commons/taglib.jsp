<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<%
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
	request.setAttribute("basePath", basePath);
%>

<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${basePath}/resources/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${basePath}/resources/themes/icon.css">

<script type="text/javascript" src="${basePath}/resources/commonjs/jquery.min.js"></script>
<script type="text/javascript" src="${basePath}/resources/commonjs/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${basePath}/resources/commonjs/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${basePath}/resources/commonjs/common.js"></script>
