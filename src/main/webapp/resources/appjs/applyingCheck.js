/**
 * 创建指标值属性tr
 */
var contentArr = [{"attrname":"kbiName"},{"attrname":"kpiCode"},{"attrname":"kpiRemark"}];
var kpiRowCount = 0;
$(function() {
	getRecordNum();
	var recordNum = $("input[name='recordNum']").val();
	$('#recordList').datagrid({
		url:'./findListCheck',
		queryParams:{
			recordNum:recordNum
		}
	});
	$('#dataFormDiv').dialog({
	    width: 610,
	    height: 480
	});
	addTableRow();
	resizeDiv('centerArea');
	$("input[name='recordNum']").focus();
	addData();
});

/**
 * 获取申请单号并赋值
 */
function getRecordNum(){
	$.getJSON('./getRecordNum?type=H',function(data){
		if(data != null){
			$("input[name='recordNum']").val(data.recordNum);
		}
	});
}


/**
 * 删除指标值行
 * @param target
 */
function removeTableRow(target){
	$.messager.confirm('提示！','您确认删除该条记录吗?',function(r){
	    if (r){
	    	$(target).parent().parent().remove();
	    	kpiRowCount--;
	    }
	});
	
}

/**
 * 保存指标值
 * @param target
 */
function saveTableRow(target){
	if($(target).attr("src").indexOf("pencil") != -1){
		var inputArr = $(target).parent().parent().children("input");
	}
}

/**
 * grid高宽自适应
 * @param divId
 */
function resizeDiv(divId){
	var gridwidth = $("#"+divId).width();
	var gridheight = $("#"+divId).height() -90;
	$("#recordList").datagrid('resize',{
		width:gridwidth,
		height:gridheight
	});
}

/**
 * 新增
 */
function addData(){
	$("#dataFormDiv").dialog('open');
	getRecordNum();
}

/**
 * 修改
 */
function editData(){
	var rows = $("#recordList").datagrid("getSelections");
	if(rows.length == 1){
	}else{
		$.messager.alert('提示！','请选择一条记录！','info');
	}
}

/**
 * 查看
 */
function viewData(){
	
}

/**
 * 导出数据
 */
function exportData(){
	
}

/**
 * 保存数据
 */
function saveData(){
	$('#saveBtn').linkbutton('disable');
	$("#applyingCheckForm").form('submit',{
		url:'./createCheck',
		onSubmit:function(){
		},success:function(data){
			$('#saveBtn').linkbutton('enable');
			clearData();
		}
	});
}

/**
 * 清理数据
 */
function clearData(){
	$("#applyingCheckForm").form('clear');
}

