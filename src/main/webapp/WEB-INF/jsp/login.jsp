<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="../common/header.jsp"%>

<!DOCTYPE html>
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
  <meta charset="UTF-8" /> 
  <title>登录验证</title> 
  <link rel="stylesheet" href="${ctx}/static/front/css/reset.css" /> 
  <link rel="stylesheet" href="${ctx}/static/front/css/style.css" media="screen" type="text/css" /> 
  <script type="text/javascript">
	 function submitForm() {
		$.ajax({
	        url : "${ctx}/user/logon.action",
	        type : "POST",
	        dataType : "json",
	        data : $("#login-form").serialize(),
	        success : function(jsonObj) {
	           if(jsonObj.status == util.SUCCESS) {
	        	   window.location.href = "${ctx}/index.action";
	           } else {
	              alert(data.msg);
	           }
	        }
	     });
	 }
	</script>
  
 </head>
 <body> 
  <div id="window" style=""> 
   <div class="page page-front"> 
    <div class="page-content">
    <form  id="login-form"> 
     <div class="input-row"> 
     
      <label class="label fadeIn">用户名</label> 
      <input id="username" type="text" name="name" data-fyll="用户名" class="input fadeIn delay1" /> 
     </div> 
     <div class="input-row"> 
      <label class="label fadeIn delay2">密码</label> 
      <input id="password" type="password" name="password" data-fyll="密码" class="input fadeIn delay3" /> 
     </div> 
     
      
     </form>
    <div class="input-row perspective"> 
     <input type="submit" onclick="submitForm()" value="登录" >
       <div class="load-state"> 
       
       </div> 
     </div> 
    </div> 
   </div> 
  </div> 
  

  <script type="text/javascript" src="${ctx}/static/front/js/fyll.js"></script> 
  <script type="text/javascript" src="${ctx}/static/front/js/index.js"></script> 
 </body>
</html>