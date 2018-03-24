<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../common/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
          var url;
        function newUser(){
            $('#dlg').dialog('open').dialog('setTitle','新增');
            $('#fm').form('clear');
            url = 'UserServlet?f=add';
        }
        function editUser(){
            var row = $('#mTb').datagrid('getSelected');
            if (row){
                $('#dlg').dialog('open').dialog('setTitle','修改');
                $('#fm').form('load',row);
                url = 'UserServlet?f=update&id=' + row.id;
            }
        }
        function saveUser(){
            $('#fm').form('submit',{
                url: url,
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                    var result = eval('('+result+')');
                    if (result.success){
                        $.messager.show({
                            title: '提示',
                            msg: result.message
                        });
                        $('#dlg').dialog('close');        // close the dialog
                        $('#mTb').datagrid('reload');    // reload the user data
                    } else {
                        $.messager.show({
                            title: '提示',
                            msg: result.message
                        });
                    }
                }
            });
        }
        function removeUser(){
            var row = $('#mTb').datagrid('getSelected');
            if (row){
                $.messager.confirm('确认','您确定要删除吗？',function(r){
                    if (r){
                        $.post('UserServlet?f=delete',{id:row.id},function(result){
                            if (result.success){
                                $.messager.show({    // show error message
                                        title: '提示',
                                        msg: result.message
                                    });
                                $('#mTb').datagrid('reload');    // reload the user data
                            } else {
                                $.messager.show({    // show error message
                                    title: '提示',
                                    msg: result.message
                                });
                            }
                        },'json');
                    }
                });
            }
        }
        function doSearch(){
            $('#mTb').datagrid('load',{
                name: $('#username').val(),
                xueli: $('#userxueli').val()
            });
        }
  </script>
</head>
<body>
	
	<table id="mTb"  class="easyui-datagrid"  style="width:700px;height:250px" toolbar="#toolbar"
			data-options="singleSelect:true,fitColumns:true,fit:true,pagination:true,collapsible:true,url:'${ctx}/customer/pageList.action',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'num',width:80">客户编号</th>
				<th data-options="field:'name',width:100">公司名称</th>
				<th data-options="field:'region',width:80,align:'right'">客户地区</th>
				<th data-options="field:'managerName',width:80,align:'right'">客户经理姓名</th>
				<th data-options="field:'level',width:80">客户等级</th>
				<th data-options="field:'fax',width:80">传真</th>
				<th data-options="field:'status',width:80">客户状态</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">新增</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeUser()">删除</a>
    </div>
   
 <div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
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