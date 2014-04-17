/**
 * 创建指标值属性tr
 */
var contentArr = [{"attrname":"kbiName"},{"attrname":"kpiCode"},{"attrname":"kpiRemark"}];
$(function() {
	$('#recordList').datagrid({
		loadFilter : pagerFilter
	}).datagrid('loadData', getData());
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
		$("input[name='recordNum']").val(data);
	});
}

/**
 * 获取表格数据
 * @returns {Array}
 */
function getData() {
	var rows = [];
	for (var i = 1; i <= 20; i++) {
		rows.push({
			recordNum : 'recordNum' + i,
			type : "家庭申请",
			agent : '王珊 ' + i,
			operatedTime : $.fn.datebox.defaults.formatter(new Date()),
			phase : "申请"+i
		});
	}
	return rows;
}

/**
 * 删除指标值行
 * @param target
 */
function removeTableRow(target){
	$.messager.confirm('提示！','您确认删除该条记录吗?',function(r){
	    if (r){
	    	$(target).parent().parent().remove();
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

function resizeDiv(divId){
	var gridwidth = $("#"+divId).width();
	var gridheight = $("#"+divId).height() -90;
	$("#recordList").datagrid('resize',{
		width:gridwidth,
		height:gridheight
	});
}

function pagerFilter(data) {
	if (typeof data.length == 'number' && typeof data.splice == 'function') { // is
																				// array
		data = {
			total : data.length,
			rows : data
		};
	}
	var dg = $(this);
	var opts = dg.datagrid('options');
	var pager = dg.datagrid('getPager');
	pager.pagination({
		onSelectPage : function(pageNum, pageSize) {
			opts.pageNumber = pageNum;
			opts.pageSize = pageSize;
			pager.pagination('refresh', {
				pageNumber : pageNum,
				pageSize : pageSize
			});
			dg.datagrid('loadData', data);
		}
	});
	if (!data.originalRows) {
		data.originalRows = (data.rows);
	}
	var start = (opts.pageNumber - 1) * parseInt(opts.pageSize);
	var end = start + parseInt(opts.pageSize);
	data.rows = (data.originalRows.slice(start, end));
	return data;
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
	$("#applyingCheckForm").form('submit',{
		url:'./createCheck',
		onSubmit:function(){
		},success:function(data){
			alert(data);
			if(data == true){
				
			}
		}
	});
}

/**
 * 清理数据
 */
function clearData(){
	
}

