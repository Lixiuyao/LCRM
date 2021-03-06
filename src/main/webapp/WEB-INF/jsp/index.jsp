<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<%@taglib prefix="myFn" uri="http://situ.com/rbac" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		
       <script>
       
				$(function(){
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
       
       
				var url;
				/* 打开添加dialog */
				function openPasswordModifyDialog(){
					url = "${ctx}/Iuser/update.action";
					$("#dialog").dialog("open").dialog('setTitle','修改');
					$("#form").form("clear");
				}
       
       	
				function openTab(title,url,icon){
					
					if($("#tabsIds").tabs("exists",title)){
						//select which 选择一个选项卡面板，'which'参数可以是选项卡面板的标题或者索引。 
						$("#tabsIds").tabs("select", title);
					}else{
						var content = "<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%'  src='"+url+"'></iframe>";
						$('#tabsIds').tabs('add',{
						title: title,
						iconCls:icon,
						content: content,
						closable: true
					});
					}
					
					
				}
       		
       	
       </script>
	</head>
	<body class="easyui-layout">
		<!--
        	描述：北边
        -->
        <div data-options="region:'north'" style="height: 100px;">
        	<table cellpadding=0 cellspacing=0 border=0 height=100% width=100%>  
              <tr height=50px>  
              
                <td width=50%><img src="${ctx}/static/img/jiemian.jpg" /></td>  
                <td width=50% align="right"> 欢迎您：${UserContext.USER_IN_SESSION}　 |  修改密码  |  退出系统  | 主页    </td>  
              </tr>  
          </table>
        </div>
        <!--
        
        	描述：西边
        -->
        <div data-options="region:'west'" title="导航菜单" style="width: 200px;">
        		 <!--手风琴-->
        		 
        		 
           <div id="aa" class="easyui-accordion" data-optiopns="border:false,fit:true" > 
           
            <c:if test="${myFn:checkPermission('yxgl')}">
          	 <div title="营销管理"  data-options="iconCls:'icon-yxgl'" style="padding:10px;">
          		 <c:if test="${myFn:checkPermission('yxgl/saleChance/index.action')}">
                  <a href="javascript:openTab('营销机会管理','${ctx}/saleChance/index.action','icon-yxjhgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-khxxgl'" style="width: 150px;">营销机会管理</a>
                </c:if>
                <c:if test="${myFn:checkPermission('yxgl/saleChance/cusDevPlan.action')}">
                  <a href="javascript:openTab('客户开发计划','${ctx}/saleChance/cusDevPlan.action','icon-khkfjh')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-khlsgl'" style="width: 150px;">客户开发计划</a>
                </c:if>
               </div>
             </c:if> 
               <c:if test="${myFn:checkPermission('khgl')}">
              <div title="客户管理"  data-options="iconCls:'icon-khgl'" style="padding:10px;">
               	<c:if test="${myFn:checkPermission('khgl/customer/index.action')}">
                  <a href="javascript:openTab('客户信息管理','${ctx}/customer/show.action ','icon-khxxgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-khxxgl'" style="width: 150px;">客户信息管理</a>
                 </c:if>
                 <c:if test="${myFn:checkPermission('khgl/customerLoss/index.action')}">
                  <a href="javascript:openTab('客户流失管理','${ctx}/customerLoss/index.action ','icon-khlsgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-khlsgl'" style="width: 150px;">客户流失管理</a>
               	 </c:if>
               </div>
               </c:if>
                 <c:if test="${myFn:checkPermission('fwgl')}">
               <div title="服务管理" data-options="iconCls:'icon-fwgl'" style="padding:10px">
                  <a href="javascript:openTab('服务创建','customerServiceCreate.jsp','icon-fwcj')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-fwcj'" style="width: 150px;">服务创建</a>
                  <a href="javascript:openTab('服务分配','customerServiceAssign.jsp','icon-fwfp')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-fwfp'" style="width: 150px;">服务分配</a>
                  <a href="javascript:openTab('服务处理','customerServiceProce.jsp','icon-fwcl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-fwcl'" style="width: 150px;">服务处理</a>
                  <a href="javascript:openTab('服务反馈','customerServiceFeedback.jsp','icon-fwfk')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-fwfk'" style="width: 150px;">服务反馈</a>
                  <a href="javascript:openTab('服务归档','customerServiceFile.jsp','icon-fwgd')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-fwgd'" style="width: 150px;">服务归档</a>
               </div>
               </c:if>
                <c:if test="${myFn:checkPermission('tjbb')}">
               <div title="统计报表"  data-options="iconCls:'icon-tjbb'" style="padding:10px">
                  <a href="javascript:openTab('客户贡献分析','${ctx}/customerGx/index.action','icon-khgxfx')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-khgxfx'" style="width: 150px;">客户贡献分析</a>
                  <a href="javascript:openTab('客户构成分析','${ctx}/customerGx/tubiaoindex.action','icon-khgcfx')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-khgcfx'" style="width: 150px;">客户构成分析</a>
                  <a href="javascript:openTab('客户服务分析','${ctx}/customerGx/customerService.action','icon-khfwfx')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-khfwfx'" style="width: 150px;">客户服务分析</a>
                  <a href="javascript:openTab('客户流失分析','khlsfx.jsp','icon-khlsfx')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-khlsfx'" style="width: 150px;">客户流失分析</a>
               </div>
               </c:if>
                <c:if test="${myFn:checkPermission('jcsjgl')}">
               <div title="基础数据管理"  data-options="iconCls:'icon-jcsjgl'" style="padding:10px">
                  <a href="javascript:openTab('数据字典管理','${ctx}/datadic/index.action','icon-sjzdgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-sjzdgl'" style="width: 150px;">数据字典管理</a>
                  <a href="javascript:openTab('产品信息查询','${ctx}/product/index.action','icon-cpxxgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-cpxxgl'" style="width: 150px;">产品信息查询</a>
                  <a href="javascript:openTab('用户信息管理','${ctx}/user/index.action','icon-user')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-user'" style="width: 150px;">用户信息管理</a>
               </div>
               </c:if>
                <c:if test="${myFn:checkPermission('qxgl')}">
               <div title="权限管理"  data-options="iconCls:'icon-khgl'" style="padding:10px;">
	                  <a href="javascript:openTab('员工管理','${ctx}/user/index2.action','icon-khxxgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-yxjhgl'" style="width: 150px;">员工管理</a>
	                  <a href="javascript:openTab('权限管理','${ctx}/permission/index.action','icon-khlsgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-khkfjh'" style="width: 150px;">权限管理</a>
	                  <a href="javascript:openTab('角色管理','${ctx}/role/index.action','icon-khlsgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-khkfjh'" style="width: 150px;">角色管理</a>
	           </div>
               </c:if>
               
               <div title="系统管理"  data-options="iconCls:'icon-item'" style="padding:10px">
                  <a href="javascript:openPasswordModifyDialog()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-modifyPassword'" style="width: 150px;">修改密码</a>
                  <a href="javascript:logout()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-exit'" style="width: 150px;">安全退出</a>
               </div>
               
               
        	</div>
        </div>
        <!--zhongjian-->
        <div data-options="region:'center'" >
        	<div id="tabsIds" class="easyui-tabs" data-options="fit:true">
        		<div title="首页"  data-options="iconCls:'icon-home'">
        		
        		</div>
        	</div>
        </div>
        
         <!-- 添加和修改的dialog 开始 -->
    <div id="dialog" style="width:350;height:280,padding: 10px 20px">
       <form action="" id="form" method="post">
           <input type="hidden" id="id" name="id"/>
           <table cellspacing="8px">
               <tr>
                  <td>用户名：</td>
                  <td><input type="text" id="dataDicValue" name="dataDicValue"  value="${UserContext.USER_IN_SESSION.name}" class="easyui-validatebox" required="true"/><font color="red">*<font color="red">*</font> </td>
               </tr>
               <tr>
                  <td>原密码：</td>
                  <td><input type="text" id="dataDicValue" name="dataDicValue" class="easyui-validatebox" required="true"/><font color="red">*</font></td>
               </tr>
               <tr>
                  <td>新密码：</td>
                  <td><input type="text" id="dataDicValue" name="dataDicValue" class="easyui-validatebox" required="true"/><font color="red">*</font></td>
               </tr>
               <tr>
                  <td>确认密码：</td>
                  <td><input type="text" id="dataDicValue" name="dataDicValue" class="easyui-validatebox" required="true"/><font color="red">*</font></td>
               </tr>
           </table>
       </form>
    </div>
    <!-- 添加和修改的dialog 结束 -->
        
        <!--下面
        -->
        <div data-options="region:'south'" style="height: 25px;" align="center">版权所有@随意抄袭</div>
	</body>
</html>