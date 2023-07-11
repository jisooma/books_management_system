<%--
  Created by IntelliJ IDEA.
  User: mazhixiu
  Date: 2020/1/8
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
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

    <div class="layui-body layui-bg-gray" style="padding: 10px">
        <!-- 内容主体区域 -->
        <div class="layui-card">
            <div class="layui-card-header">课程列表</div>
            <div class="layui-card-body">
                <table class="layui-table">
                    <colgroup>
                        <col width="150">
                        <col width="200">
                        <col>
                    </colgroup>
                    <thead>
                    <tr>
                        <th width="35%">课程号</th>
                        <th width="35%">课程名</th>
                        <th width="30%">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${courses}" var="course">
                        <tr>
                            <th>${course.cno}</th>
                            <th>${course.cname}</th>
                            <th>
<%--                                <form action="teacher_book_add.js">--%>
<%--                                    <input type="button" name="submit" value="${course.cno}" style="color:blueviolet;font-size:16px">--%>
<%--                                </form>--%>
                                <%
                                   // request.setAttribute("id",'${course.cno}');
                                %>
                                     <a href="teacher_book_add.jsp" style="color:blueviolet;font-size:16px"> 添加教材</a>
                            </th>
                        </tr>
                    </c:forEach>
                    </tbody>
                    </thead>
                </table>

            </div>
        </div>

    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
    </div>

</div>
<script src="js/jquery-1.11.0.min.js"></script>
<script src="./layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
    layui.use('layer', function () {
        var layer = layui.layer;

    });


</script>
</body>
