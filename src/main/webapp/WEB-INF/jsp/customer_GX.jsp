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
			url:"${ctx}/customerGx/pageAll.action",
			method:"get",
			fit : true,
			rownumbers:true,
			fitColumns : true,
			pagination : true,
			toolbar: "#toolbar",
			columns:[[
			      {field:"cb",checkbox:true,algin:"center"},  
			    {field:"id",title:"编号",width:80,algin:"center"},     
			    {field:"name",title:"公司名称",width:80,algin:"center"},     
			    {field:"totalprice",title:"订单总金额",width:80,algin:"center"},     
			    ]],
		});
	});
	
	
	
	
	
	

	
	
</script>
</head>
<body>
	<table id="datagrid"></table>
	
   
    <!-- 添加和修改的dialog 结束 -->
</body>
</html>