<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="css/global.css" rel="stylesheet" type="text/css" />
<link href="css/login.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
   <div id="wrap">
  <div id="login">
    <div class="loginfrom">
    <!-- 访问服务器 方式一：提交form表单   
                            访问服务器方式二： 超链接传递
                        访问服务器方式三：AJax    Jquery的方式实现Ajax
    
     -->
      <form action="userServlet" method="post">
      	<input type="hidden" value="dologin" name="opertype"/>
        <fieldset>
         
          <ul>
            <li class="current">Toto用户</li>
            <li>Vancl用户</li>
          </ul>
          <div class="box">
            <p style="width:300px">
              <label>用户名：</label>
              <input id="login_name" name="login_name" type="text" value="" />
            </p>
            <p>
              <label class="pw">密 码：</label>
              <input id="login_password" name="login_password" type="text" />
            </p>
            <p>
              <input name="" type="submit" value="登录"  class="loginbtn"  />
              <a href="#">忘记密码了？</a></p>
          </div>
          <div class="cooperation">使用合作伙伴账号登录Vjia：<a href="#"><img src="images/account_qq.gif" width="49" height="21" /></a></div>
          <dl>
            <dt>温馨提示：</dt>
            <dd>如果还未注册用户，您可以使用用户名进行登录，登录后系统会自动为您注册一个与帐户相关联的VJIA帐户。帐户关联后您可共享VANCL的会员积分和消费金额。</dd>
            <dd class="f_right">有任何疑问请点击 <a href="#">帮助中心</a> 或 <a href="#">联系客服</a></dd>
          </dl>
        </fieldset>
      </form>
    </div>
    
  </div>
  
</div>
  </body>
</html>
