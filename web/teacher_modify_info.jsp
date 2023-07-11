<%--
  Created by IntelliJ IDEA.
  User: mazhixiu
  Date: 2020/1/7
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>修改管理员信息 </title>
    <link rel="stylesheet" href="./layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo" style="color: #F0F0F0">教材征订与发放管理系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    ${sessionScope.user.tno}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="LoginServlet?option=quit">退出</a></dd>
                </dl>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;"><i class="layui-icon layui-icon-user"></i>教材管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="BookServlet?option=showAllBooksToTeacherA">全部教材</a></dd>
                        <dd><a href="CourseServlet?option=showAllCourses">录入教材</a></dd>
                        <dd><a href="BookServlet?option=showAllBooksToTeacher">我的教材</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon layui-icon-template-1"></i> 个人信息管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="teacher_modify_info.jsp?">修改信息</a></dd>
                        <dd><a href="teacher_modify_pwd.jsp?">修改密码</a></dd>
                    </dl>
                    </dl>
                </li>

            </ul>

        </div>
    </div>

    <div class="layui-body layui-bg-gray">
        <div style="width: 450px;margin: 10px auto" class="layui-card">
            <div class="layui-card-header">修改个人信息</div>
            <div class="layui-card-body">
                <form class="layui-form" action="ModifyInfoServlet">
                    <div class="layui-form-item">
                        <label class="layui-form-label">教师号</label>
                        <div class="layui-input-block">
                            <input type="text" name="tno" value=" ${sessionScope.user.tno}" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input"readonly="readonly">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">姓名</label>
                        <div class="layui-input-block">
                            <input type="text" name="tname" value=" ${sessionScope.user.tname}" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">系别</label>
                        <div class="layui-input-block">
                            <input type="text" name="dept" value=" ${sessionScope.user.tdept}"  placeholder="" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">邮箱</label>
                        <div class="layui-input-block">
                            <input type="text" name="email" value=" ${sessionScope.user.temail} " placeholder="" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">课程号</label>
                        <div class="layui-input-block">
                            <input type="text" name="cno" value=" ${sessionScope.user.tcno} " placeholder="" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">电话</label>
                        <div class="layui-input-block">
                            <input type="text" name="tel" value=" ${sessionScope.user.ttel} " placeholder="" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn" lay-submit lay-filter="formDemo">确认修改</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                    <input style="display: none" name="option" value="updateTeacherInfo">
                </form>
            </div>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
    </div>
    <c:if test="${not empty msg}">
        <script>
            alert("${msg}");
        </script>
    </c:if>

</div>
<script src="js/jquery-1.11.0.min.js"></script>
<script src="./layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
    layui.use('form', function(){
        var form = layui.form;
    });



</script>
</body>
</html>
