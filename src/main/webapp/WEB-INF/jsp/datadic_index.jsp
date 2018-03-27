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
			url:"${ctx}/datadic/pageList.action",
			method:"get",
			fit : true,
			fitColumns : true,
			pagination : true,
			toolbar: "#toolbar",
			columns:[[
			      {field:"cb",checkbox:true,algin:"center"},  
			    {field:"id",title:"编号",width:80,algin:"center"},     
			    {field:"dataDicName",title:"数据字典名",width:80,algin:"center"},     
			    {field:"dataDicValue",title:"数据字典值",width:80,algin:"center"},     
			 
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
			dataDicName:$('#dataDicName').val(),
			dataDicValue:$('#dataDicValue').val(),
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
					url : "${ctx}/datadic/delete.action",
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
		url = "${ctx}/datadic/insert.action";
		$("#dialog").dialog("open").dialog('setTitle','新增');
		$("#form").form("clear");
	}
	
	//修改数据
	function openUpdateDialog(){
		url = "${ctx}/datadic/update.action"; 
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
			/* 	if($("#roleName").combobox("getValue") == ""){
					$.messager.alert("系统提示","请选择用户角色");
					return false;
				} */
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

	
	
</script>
</head>
<body>
	<table id="datagrid"></table>
	<div id="toolbar">
        <a href="javascript:openAddDialog()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增</a>
        <a href="javascript:openUpdateDialog()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" >修改</a>
        <a href="javascript:doDelete()" class="easyui-linkbutton" iconCls="icon-remove" plain="true" >删除</a>
   		<div>
   			数据字典名：<input id="dataDicName" class="easyui-combobox" data-options ="
   				valueField:'dataDicName',
   				textField:'dataDicName',
   				url:'${ctx}/datadic/findDatadicName.action',
   				panelHeight:'auto',
   				 editable:false,  
   				" 
   			/>
   			
   			
   			数据字典值：<input type="text" id="dataDicValue"/>
   			
	   		<a href="javascript:doSearch()" class="easyui-linkbutton" data-options="iconCls:'icon-search'" >搜索</a>	
   		 </div>
    </div>
    <!-- 添加和修改的dialog 开始 -->
    <div id="dialog" style="width:750;height:280,padding: 10px 20px">
       <form action="" id="form" method="post">
           <input type="hidden" id="id" name="id"/>
           <table cellspacing="8px">
               <tr>
                  <td>数据字典名：</td>
                  <td><input type="text" id="dataDicName" name="dataDicName" required="true" class="easyui-combobox" data-options ="
			   				valueField:'dataDicName',
			   				textField:'dataDicName',
			   				url:'${ctx}/datadic/findDatadicName.action',
			   				panelHeight:'auto',
			   				 editable:false,  
   				" /><font color="red">*</font>  <a href="javascript:openAdd()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增</a></td>
                   <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                  <td>数据字典值：</td>
                  <td><input type="text" id="dataDicValue" name="dataDicValue" class="easyui-validatebox" required="true"/><font color="red">*</font></td>
               </tr>
           </table>
       </form>
    </div>
    <!-- 添加和修改的dialog 结束 -->
</body>
</html>