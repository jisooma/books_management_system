<%--
  Created by IntelliJ IDEA.
  User: mazhixiu
  Date: 2020/1/5
  Time: 1:06
  To change this template use File | Settings | File Templates.
--%>

<%--<%@ page import="com.javaweb.demo.entity.Teacher" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta charset="utf-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">--%>
<%--    <title>layout 后台大布局 - Layui</title>--%>
<%--    <link rel="stylesheet" href="./layui/css/layui.css">--%>
<%--</head>--%>
<%--<body class="layui-layout-body">--%>
<%--<div class="layui-layout layui-layout-admin">--%>
<%--    <div class="layui-header">--%>
<%--        <div class="layui-logo" style="color: #F0F0F0">教材征订与发放管理系统</div>--%>
<%--        <!-- 头部区域（可配合layui已有的水平导航） -->--%>
<%--        <ul class="layui-nav layui-layout-right">--%>
<%--            <li class="layui-nav-item">--%>
<%--                <a href="javascript:;">--%>
<%--                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">--%>
<%--                    ${sessionScope.user.username}--%>
<%--                </a>--%>
<%--                <dl class="layui-nav-child">--%>
<%--                    <dd><a href="LoginServlet?option=quit">退出</a></dd>--%>
<%--                </dl>--%>
<%--            </li>--%>
<%--        </ul>--%>
<%--    </div>--%>

<%--    <div class="layui-side layui-bg-black">--%>
<%--        <div class="layui-side-scroll">--%>
<%--            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->--%>
<%--            <ul class="layui-nav layui-nav-tree"  lay-filter="test">--%>
<%--                <li class="layui-nav-item layui-nav-itemed">--%>
<%--                    <a class="" href="javascript:;"><i class="layui-icon layui-icon-user"></i> 教材管理</a>--%>
<%--                    <dl class="layui-nav-child">--%>
<%--                        <dd><a href="CourseServlet?option=">课程列表</a></dd>--%>
<%--                        <dd><a href="BookServlet?option=">教材列表</a></dd>--%>
<%--                    </dl>--%>
<%--                </li>--%>
<%--                <li class="layui-nav-item">--%>
<%--                    <a href="javascript:;"><i class="layui-icon layui-icon-template-1"></i> 个人信息</a>--%>
<%--                    <dl class="layui-nav-child">--%>
<%--                        <dd><a href="TeacherServlet?">修改信息</a></dd>--%>
<%--                        <dd><a href="ModifyPwdServlet?">修改密码</a></dd>--%>
<%--                    </dl>--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--    </div>--%>

<%--    <div class="layui-body layui-bg-gray">--%>
<%--        <!-- 内容主体区域 -->--%>
<%--        <div class="layui-card" style="margin: 10px auto;width: 1200px;">--%>
<%--            <div style="font-size: 40px;text-align: center" class="layui-card-body">--%>
<%--                <%--%>
<%--//                    HttpSession session1 = request.getSession();--%>
<%--//                    Teacher user = (Teacher) session1.getAttribute("user");--%>
<%--//                    out.println("欢迎您,老师:"+user.getName());--%>
<%--                %>--%>
<%--            </div>--%>
<%--            <div>--%>
<%--                <img width="1200px" src="images/bg3.png" alt="">--%>
<%--            </div>--%>
<%--        </div>--%>

<%--    </div>--%>

<%--    <div class="layui-footer">--%>
<%--        <!-- 底部固定区域 -->--%>
<%--    </div>--%>

<%--</div>--%>
<%--<script src="js/jquery-1.11.0.min.js"></script>--%>
<%--<script src="./layui/layui.js"></script>--%>
<%--<script>--%>
<%--    //JavaScript代码区域--%>
<%--    layui.use('element', function(){--%>
<%--        var element = layui.element;--%>

<%--    });--%>
<%--    layui.use('form', function(){--%>
<%--        var form = layui.form;--%>
<%--    });--%>



<%--</script>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page import="com.javaweb.demo.entity.Admin" %>
<%@ page import="com.javaweb.demo.entity.Teacher" %>
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

    <div class="layui-body layui-bg-gray">
        <!-- 内容主体区域 -->
        <div class="layui-card" style="margin: 10px auto;width: 1200px;">
            <div style="font-size: 40px;text-align: center" class="layui-card-body">
                                <%
                                    HttpSession session1 = request.getSession();
                                    Teacher user = (Teacher) session1.getAttribute("user");
                                    out.println("欢迎您,老师:"+user.getTname());
                                %>
            </div>
            <div>
                <img width="1200px" src="images/bg3.png" alt="">
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
    layui.use('form', function(){
        var form = layui.form;
    });



</script>
</body>
</html>