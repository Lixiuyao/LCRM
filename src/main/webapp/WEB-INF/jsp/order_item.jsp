<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function() {
	
	$.post("${ctx}/customer/selectById.action", 
			{id : '${param.id}'}, 
			function(result) {
				if(result.status==util.SUCCESS) {	
					$("#numId").val(result.data.id);
					$("#nameId").val(result.data.name);
				}
				
			}, 
			"json");
	
	
	
	/*展示数据的datagrid表格*/
	$("#datagrid").edatagrid({
		url:'${ctx}/customerOrderItem/selectAll.action?orderId=${param.orderId}',//只查询已分配的咨询师
		saveUrl:'${ctx}/customerOrderItem/add.action?orderId=${param.orderId}',//添加
		updateUrl:'${ctx}/customerOrderItem/update.action?orderId=${param.orderId}',//更新
		destroyUrl:'${ctx}/customerOrderItem/deleteById.action',//删除
		method:'get',
		fit:true,
		singleSelect:false,
		toolbar:'#toolbar',
		rownumbers:true,
		fitColumns:true,
		pagination:true,
		columns:[[    
				{field:'id',title:'编号',width:80,align:'center'},    
				{field:'productName',title:'商品名称',width:100,align:'center' ,editor:{type:'validatebox',options:{required:true}}},    
				{field:'productNum',title:'商品数量',width:100,align:'center',editor:{type:'datebox',options:{required:true}}},    
				{field:'unit',title:'单位',width:100,align:'center',editor:{type:'validatebox',options:{required:true}}},    
				{field:'price',title:'价格',width:100,align:'center',editor:{type:'validatebox',options:{required:true}}},
				{field:"sum",title:"总金额",width:80,align:"center",editor:{type:'validatebox',options:{required:true}}},
		]]  
	});
});
</script>
</head>
<body>
	<div id="p" class="easyui-panel" title="My Panel" >
		<!-- 添加和修改的dialog 开始 -->
		<form action="" id="form" method="post">
			<input type="hidden" id="id" name="id"/>
			<table cellspacing="8px">
				<tr>
					<td>编号	：</td>
					<td><input type="text" id="numId" name="num" class="easyui-textbox" readonly="readonly"/></td>
					<td>客户名称：</td>
					<td><input type="text" id="nameId" name="name" class="easyui-textbox" readonly="readonly" /></td>
				</tr>
			</table>
		</form>
		
	<!-- 添加和修改的dialog 结束 -->    
	</div>  
<!-- panl -->

	<table id="datagrid" idField="id"></table>
->
</body>
</html>