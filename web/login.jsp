
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
  <title>登录</title>

  <link rel="stylesheet" href="./Flat Login Form_files/reset.min.css">

  <link rel="stylesheet" href="./Flat Login Form_files/css">
  <link rel="stylesheet" href="./Flat Login Form_files/css(1)">
  <link rel="stylesheet" href="./Flat Login Form_files/font-awesome.min.css">
  <link rel="stylesheet" href="./Flat Login Form_files/style.css">


</head>

<body>
  
<div class="container">
  <div class="info">

    <h1>教材征订与分发管理系统</h1>
  </div>
</div>

<div class="form">
  <div class="thumbnail"><img src="./Flat Login Form_files/hat.png"></div>


  <form action="LoginServlet" method="post">
<%--      <c:if test="${msg != null}">--%>
<%--          <div class="form-group">--%>
<%--              <div class="alert alert-danger" role="alert">${msg}</div>--%>
<%--          </div>--%>
<%--      </c:if>--%>
    <input type="text" name="name" placeholder="账号" style="width:100%;">
    <input type="password" name="pwd" placeholder="密码" maxlength="10" style="width:100%;">
    <br>&emsp;&emsp;
<%--      <input type="radio" name="type" value="0"checked>管理员--%>
<%--      <input type="radio" name="type" value="1">教师--%>
<%--      <input type="radio" name="type" value="2">班长--%>
    <br>
    <input type="submit"value="登录"name="denglu"style="width:100%;background-color:red">
    <p class="message" align="left"><a href="">忘记密码</a></p>
  </form>
</div>

  <script src="./Flat Login Form_files/jquery.min.js"></script>
    <script src="./Flat Login Form_files/index.js"></script>

</body>
</html>