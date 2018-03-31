<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function(){
		$("#datagrid").datagrid({
			url:"${ctx}/customerLoss/pageList.action",
			method:"get",
			fit : true,
			fitColumns : true,
			pagination : true,
			toolbar: "#toolbar",
			columns:[[
			      {field:"cb",checkbox:true,algin:"center"},  
			    {field:"id",title:"编号",width:80,algin:"center"},     
			    {field:"customerNo",title:"客户编号",width:80,algin:"center"},     
			    {field:"customerName",title:"客户名称",width:80,algin:"center"},     
			    {field:"customerManager",title:"客户经理",width:80,algin:"center"}, 
			    {field:"lastOrderTime",title:"上次下单时间",width:80,algin:"center"},    
			    {field:"confirmLossTime",title:"确认流失时间",width:80,algin:"center"},     
			    {field:"lossReason",title:"流失原因",width:80,algin:"center"},     
			    {field:'status',title:'分配状态',width:80,align:'center',formatter:function(value,row,index){
			    	 //客户开发状态 0 未开发 1 开发中 2 开发成功 3 开发失败
			    	 if(value==0){
			    		 return "暂缓流失";
			    	 }else if(value==1){
			    		 return "已流失";
			    	 }
			     }}, 
			     
			     {field:'asdf',title:'操作',width:100,align:'center',formatter:function(value,row,index){
			    	 if(row.status==0){
			    		 return "<a href='javascript:openCusDevPlanTab("+row.id+",false)'>暂缓流失措施</a>";
			    	 }else if(row.status==1){
			    		 return "<a href='javascript:openCusDevPlanTab("+row.id+",true)'>客户已流失</a>";
			    	 }	 
			     }},    
			         
			    ]],
		});
		
	
	
	
	

	})
	
	//可以修改添加开发项
			function openCusDevPlanTab(id,isShow){
				 window.parent.openTab('客户开发计划项管理','${ctx}/customerLoss/JHindex.action?id='+id+'&show='+isShow,'icon-khkfjh');
			}
	
		//搜索
	function doSearch(){
		//load加载和显示第一页的所有行。如果指定了'param'，
		//它将取代'queryParams'属性通常可以通过传递一些参数执行一次查询，通过调用这个方法从服务器加载新数据。
		$('#datagrid').datagrid('load',{
			customerName:$('#s_name').val(),
			customerManager:$('#s_manager').val(),
			status:$('#s_status').val()
		});
	}
	
	
	
	
		

	
	
</script>
</head>
<body>
	<table id="datagrid"></table>
	<div id="toolbar">
   		<div>
   			客户名称:<input type="text" id="s_name"/>
   			客户经理：<input type="text" id="s_manager"/>
   			客户状态：<select id="s_status" class="easyui-combobox"
   				editable="false" panelHeight="auto">
   					<option value="">请选择...</option>
   					<option value="0">暂缓流失</option>
   					<option value="1">已流失</option>
	   			</select>
	   		<a href="javascript:doSearch()" class="easyui-linkbutton" data-options="iconCls:'icon-search'" >搜索</a>	
   		 </div>
    </div>

</body>
</html>