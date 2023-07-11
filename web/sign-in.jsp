<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>登录</title>

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/style.css">

</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">


            <!-- Start Sign In Form -->
            <form action="LoginServlet" class="fh5co-form animate-box" data-animate-effect="fadeIn">
                <h2>Sign In</h2>
                <c:if test="${msg != null}">
                    <div class="form-group">
                        <div class="alert alert-danger" role="alert">${msg}</div>
                    </div>
                </c:if>

                <div class="form-group">
                    <select class="form-control" name="type">
                        <option value ="manager">管理员</option>
                        <option value ="teacher">教师</option>
                        <option value ="monitor">班长</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="username" class="sr-only">Username</label>
                    <input type="text" name="username" class="form-control" id="username" placeholder="用户名" autocomplete="off">
                </div>
                <div class="form-group">
                    <label for="password" class="sr-only">Password</label>
                    <input type="password" name="password" class="form-control" id="password" placeholder="密码" autocomplete="off">
                </div>
                <div text-align:center class="form-group">
                    <input type="submit" value="登录" class="btn btn-primary" >
                </div>
                <input style="display: none" type="text" name="option" value="signIn">
            </form>
            <!-- END Sign In Form -->

        </div>
    </div>
</div>
<!-- jQuery -->
<script src="js/jquery-1.11.0.min.js"></script>
<!-- Bootstrap -->
<script src="js/bootstrap.min.js"></script>

</body>
</html>
