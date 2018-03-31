<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../common/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function(){
		$("#datagrid").datagrid({
			url:"${ctx}/customer/pageList.action",
			method:"get",
			fit : true,
			fitColumns : true,
			pagination : true,
			toolbar: "#toolbar",
			columns:[[
			      {field:"cb",checkbox:true,algin:"center"},  
			    {field:"num",title:"客户编号",width:80,algin:"center"},     
			    {field:"name",title:"公司名称",width:80,algin:"center"},     
			    {field:"managerName",title:"客户经理姓名",width:80,algin:"center"},     
			    {field:"level",title:"客户等级",width:80,algin:"center"}, 
			    {field:"region",title:"客户地区",width:80,algin:"center"},    
			    {field:"phone",title:"联系电话",width:80,algin:"center"},     
			    {field:"satisfy",title:"客户满意度",width:80,algin:"center"},     
			    {field:"credit",title:"客户信用度",width:80,algin:"center"},     
			     
			    ]],
		});
		/* 初始化添加dialog */
		$("#dialog").dialog({
		    closed : true, 
		    buttons : [
		        {
		        	text : "保存",
		        	iconCls : "icon-ok",
		        	handler : function() {
		        		doAddOrUpdate();
		        	}
		        },
		        {
		        	text : "关闭",
		        	iconCls : "icon-cancel",
		        	handler : function() {
		        		$("#dialog").dialog("close");
		        	}
		        }
		    ]
			}); 

	});
	
	
	
	
	//搜索
	function doSearch(){
		//load加载和显示第一页的所有行。如果指定了'param'，
		//它将取代'queryParams'属性通常可以通过传递一些参数执行一次查询，通过调用这个方法从服务器加载新数据。
		$('#datagrid').datagrid('load',{
			name:$('#s_name').val(),
			email:$('#s_email').val(),
			roleName:$('#s_roleName').val()
		});
	}
	
	function doDelete(){
		//getSelections none 返回所有被选中的行，当没有记录被选中的时候将返回一个空数组。 
		var ids = util.getSelectedIds($('#datagrid').datagrid("getSelections"));
		if(ids.length == 0){
			$.messager.alert("系统提示","清选择要删除的数据");
			return ;
		}
		console.log(ids);
		$.messager.confirm("系统提示","要删除这"+ids.length+"条数据？",function(r){
			if(r){
				ids = ids.join(',');
				$.ajax({
					url : "${ctx}/user/delete.action",
					data : {ids : ids},
					dataType : "json",
					type : "POST",
					success : function(jsonObj) {
						$.messager.alert("系统提示", jsonObj.msg);
						if(jsonObj.code == util.SUCCESS) {
							$("#datagrid").datagrid("reload");
						}
					}
				});
			}
		});
		
	}
	
	var url;
	/* 打开添加dialog */
	function openAddDialog(){
		url = "${ctx}/user/insert.action";
		$("#dialog").dialog("open");
		$("#form").form("clear");
	}
	
	//修改数据
	function openUpdateDialog(){
		url = "${ctx}/user/update.action"; 
		var selections = $("#datagrid").datagrid("getSelections");
		if(selections.length==0){
			$.messager.alert("系统提示", "请选择要修改的数据");
			return;
		}
		var row = selections[0];
		console.log(row);
		$("#dialog").dialog("open").dialog("setTitle","修改信息");
		//load读取记录填充到表单中。数据参数可以是一个字符串或一个对象类型，如果是字符串则作为远程URL，否则作为本地记录
		$("form").form("load", row);
		
	}
	
	
	
	
	/* 真正的去添加或者更新用户 */
	function doAddOrUpdate() {
		$("#form").form("submit",{
			url:url,
			onSubmit:function(){
				if($("#roleName").combobox("getValue") == ""){
					$.messager.alert("系统提示","请选择用户角色");
					return false;
				}
				return $(this).form("validate");//返回false终止表单提交
			},
			success:function(data){
				var jsonObj = eval("("+data+")");
				$.messager.alert("系统提示",jsonObj.msg);
				if(jsonObj.code == util.SUCCESS){
					$("#dialog").dialog("close");
					$("#datagrid").datagrid("reload");
				}
			}
		}
		);
		
	}
	
	function openContactsTab(){
		/* url = "${ctx}//update.action";  */
		var id =  util.getSelectedIds($('#datagrid').datagrid("getSelections"));
		if(id.length==0){
			$.messager.alert("系统提示", "请选择要查看的数据");
			return;
		}if(id.length>1){
			$.messager.alert("系统提示", "仅允许选中一条数据查看");
			return;
		}if(id.length==1){
		  window.parent.openTab('联系人管理','${ctx}/customer/lxrIndex.action?id='+id,'icon-lxr');
			
		}
		
	}
	function openHistoricalorderTab(){
		var id =  util.getSelectedIds($('#datagrid').datagrid("getSelections"));
		if(id.length==0){
			$.messager.alert("系统提示", "请选择要查看的数据");
			return;
		}if(id.length>1){
			$.messager.alert("系统提示", "仅允许选中一条数据查看");
			return;
		}if(id.length==1){
		  window.parent.openTab('历史订单管理','${ctx}/customerOrder/index.action?id='+id,'icon-lxr');
			
		}
	 }
	
	
	
	
</script>
</head>
<body>
	
	<table id="datagrid" ></table>
	<div id="toolbar">
        <a href="javascript:openAddDialog()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增</a>
        <a href="javascript:openUpdateDialog()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" >修改</a>
        <a href="javascript:doDelete()" class="easyui-linkbutton" iconCls="icon-remove" plain="true" >删除</a>

        <a class="easyui-linkbutton l-btn l-btn-small" href="javascript:openContactsTab('customerLinkMan','icon-lxr')"
         iconcls="icon-lxr" group="" id="">联系人管理</a>
        <a class="easyui-linkbutton l-btn l-btn-small" href="javascript:openNewTab('customerContact','icon-lxr')"
         iconcls="icon-jwjl" group="" id="">交往记录管理</a>
        <a class="easyui-linkbutton l-btn l-btn-small" href="javascript:openHistoricalorderTab('customerOrder','icon-lxr')"
         iconcls="icon-lsdd" group="" id="">历史订单查看</a>
        <div>
   			用户名:<input type="text" id="s_name"/>
   			邮箱：<input type="text" id="s_email"/>
	   		<a href="javascript:doSearch()" class="easyui-linkbutton" data-options="iconCls:'icon-search'" >搜索</a>	
   		 </div>
   	</div>
   
 	<div id="dialog" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <div class="ftitle">客户信息</div>
        <form id="fm" method="post" novalidate>
            <div class="fitem">
                <label>公司名称:</label>
                <input name="name" class="easyui-validatebox" required="true">
            </div>
            <div class="fitem">
                <label>客户地址:</label>
                <input name="region" class="easyui-validatebox" required="true">
            </div>
            <div class="fitem">
                <label>客户经理:</label>
                <input name="managerName" class="easyui-validatebox" required="true">
            </div>
            <div class="fitem">
                <label>客户传真:</label>
                <input name="fax" class="easyui-validatebox" required="true">
            </div>
             <div class="fitem">
                <label>客户状态:</label>
               	<select  name="status"  >
               		<option value="">请选择状态</option>
               		<option value="0">正常</option>
               		<option value="1">客户流失</option>
               	</select>
            </div>
           
        </form>
    </div>
	<div id="dlg-buttons">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">提交</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
    </div>
</body>
</html>