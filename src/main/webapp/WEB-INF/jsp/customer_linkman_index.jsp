
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function(){
		//查询指定id的销售机会
		$.post("${ctx}/customer/selectById.action", 
				{id : '${param.id}'}, 
				function(result) {
					if(result.status==util.SUCCESS) {	
						$("#customerId").val(result.data.id);
						$("#chanceName").val(result.data.name);
					}
					
				}, 
				"json");
		
		/*展示数据的datagrid表格*/
		$("#datagrid").edatagrid({
			url:'${ctx}/customerLinkMan/selectAll.action?customerId=${param.id}',//只查询已分配咨询师的
			saveUrl:'${ctx}/customerLinkMan/add.action?customerId=${param.id}',
			updateUrl:'${ctx}/customerLinkMan/update.action?customerId=${param.id}',
			destroyUrl:'${ctx}/customerLinkMan/delete.action',
			title:'门人',
			singleSelect:true,
			toolbar:'#toolbar',
			rownumbers:true,
			fitColumns:true,
			columns:[[    
					     {field:'cb',checkbox:true,align:'center'},    
					     {field:'id',title:'编号',width:80,align:'center'},    
					     {field:'linkName',title:'姓名',width:100,align:'center' ,editor:{type:'validatebox',options:{required:true}}},    
					     {field:'gender',title:'性别',width:100,align:'center',editor:{type:'validatebox',options:{required:true}}},    
					     {field:'position',title:'职位',width:100,align:'center',editor:{type:'validatebox',options:{required:true}}},    
					     {field:'officePhone',title:'办公电话',width:100,align:'center',editor:{type:'validatebox',options:{required:true}}},    
					     {field:'phone',title:'手机',width:100,align:'center',editor:{type:'validatebox',options:{required:true}}},
					     
					]],
			onSuccess : function() {
				$('#datagrid').edatagrid('reload');
				console.log("onSuccess");
			},
			onDestroy : function() {
				$('#datagrid').edatagrid('reload');
				console.log("onDestroy");
			}
		});
	});
	
	//更新销售机会客户开发状态
	function updateSaleChanceDevResult(devResult){
		 $.post("${ctx}/saleChance/updateDevResult.action",
				 {saleChanceId:'${param.saleChanceId}',devResult:devResult},
				 function(result){
					 if(result.code == util.SUCCESS){
						 $.messager.alert("系统提示","执行成功！");
						 //执行成功或失败后，隐藏工具条，因为不需要开发了
						 $("#toolbar").hide();
					 }else{
						 $.messager.alert("系统提示","执行失败！");
					 }
		 		},
		 		"json");
	 }
		
</script>
</head>
<body>
	<!-- 营销机会信息面板  开始 -->
	<div id="p" class="easyui-panel" title="销售机会信息" style="width: 700px;height: 100px">
	 	<table cellspacing="8px">
	   		<tr>
	   			<td>编号：</td>
	   			<td><input type="text" id="customerId" name="customerName" readonly="readonly"/></td>
	   			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	   			<td>客户名称</td>
	   			<td><input type="text" id="chanceName" name="chanceSource" readonly="readonly"/></td>
	   		</tr>
	   		
	   	</table>
	 </div>
	 <!-- 营销机会信息面板  结束  -->
	 
	 <br/>
	 
	<!-- 客户开发计划项table -->
	<table id="datagrid" style="width:700px;height:250px" idField="id"></table>
	<!-- toolbar 开始 -->
	<div id="toolbar">
		
				<div> 
					<a class="easyui-linkbutton" href="javascript:$('#datagrid').edatagrid('addRow')" iconCls="icon-add">添加</a>&nbsp;&nbsp;
					<a class="easyui-linkbutton" href="javascript:$('#datagrid').edatagrid('destroyRow')" iconCls="icon-remove">删除</a>&nbsp;&nbsp;
					<a class="easyui-linkbutton" href="javascript:$('#datagrid').edatagrid('saveRow');$('#datagrid').edatagrid('reload')" iconCls="icon-save">保存</a>&nbsp;&nbsp;
					<a class="easyui-linkbutton" href="javascript:$('#datagrid').edatagrid('cancelRow')" iconCls="icon-undo">撤销行</a>&nbsp;&nbsp;
				</div>
		
	</div>
<!-- toolbar 结束 -->
	
</body>
</html>
