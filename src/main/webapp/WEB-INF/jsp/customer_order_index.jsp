
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
			url:'${ctx}/customerOrder/selectById.action?customerId=${param.id}',//只查询已分配咨询师的
			rownumbers:true,//出默认的123456789
			singleSelect:true,
			toolbar:'#toolbar',
			rownumbers:true,
			fit:true,
			fitColumns:true,
			columns:[[    
					     {field:'cb',checkbox:true,align:'center'},    
					     {field:'customerId',title:'编号',width:80,align:'center'},    
					     {field:'orderNo',title:'订单号',width:100,align:'center' ,editor:{type:'validatebox',options:{required:true}}},    
					     {field:'orderDate',title:'订购日期',width:100,align:'center',editor:{type:'validatebox',options:{required:true}}},    
					     {field:'address',title:'送货地址',width:100,align:'center',editor:{type:'validatebox',options:{required:true}}},    
					     {field:'status',title:'状态',width:100,align:'center',formatter:function(value,row,index){
					    	 if(value==1){
					    		 return "已回款";
					    	 }else{
					    		 return "未汇款";
					    	 }
					    }} ,
					    {field:'asdf',title:'操作',width:100,align:'center',formatter:function(value,row,index){
					    	
					    		 return "<a href='javascript:openCusDevPlanTab("+row.id+")'>订单详情</a>";
					    	 
					     }}, 
					     
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
	
	function openCusDevPlanTab(id){
		 window.parent.openTab('订单详情','${ctx}/customerOrderItem/index.action?orderId='+id+'&show='+isShow,'icon-khkfjh');
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
	<table id="datagrid" style="width:700px;height:250px" idField="id"  data-options="fit:'true'" ></table>

	
</body>
</html>
