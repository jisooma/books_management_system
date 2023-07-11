<%--
  Created by IntelliJ IDEA.
  User: mazhixiu
  Date: 2020/1/5
  Time: 9:36
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
                    ${sessionScope.user.mno}
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
                    <a class="" href="javascript:;"><i class="layui-icon layui-icon-user"></i> 初始化管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="manager_initial.jsp">导入课程</a></dd>
                        <dd><a href="">导入班级</a></dd>
                        <dd><a href="">导入教师</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;"><i class="layui-icon layui-icon-user"></i> 教师管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="TeacherServlet?option=showAllTeachers">教师列表</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon layui-icon-template-1"></i> 班级管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="MonitorServlet?option=showAllMonitor">班级列表</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon layui-icon-form"></i> 教材管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="BookServlet?option=showAllBooks">教材列表</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon layui-icon-form"></i> 预定管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="ReserveServlet?option=showReserveManager">全部预定</a></dd>
                        <dd><a href="ReserveServlet?option=showUnDealReserve">未处理预定</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon layui-icon-form"></i>采购管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="PurchaseServlet?option=showPurchase">采购清单</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon layui-icon-user"></i> 个人管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="manager_modify_info.jsp?">修改信息</a></dd>
                        <dd><a href="manager-modify-pwd.jsp?">修改密码</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body layui-bg-gray">
        <!-- 内容主体区域 -->
        <div style="margin: 15px" class="layui-card">

            <div class="layui-card-header">教师列表</div>
            <button id="btn_add" class="layui-btn"style="text-align:right">增加教师</button>
            <button id="btn_add1" class="layui-btn"style="text-align:right">查询教师</button>
            <div class="layui-card-body">
                <table class="layui-table">
                    <colgroup>
                        <col width="150">
                        <col width="200">
                        <col>
                    </colgroup>
                    <thead>
                    <tr>
                        <th>教师号</th>
                        <th>姓名</th>
                        <th>院系</th>
                        <th>电话</th>
                        <th>邮箱</th>
                        <th>所任课程</th>
                        <th>课程名</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${teachers}" var="teacher">
                        <tr>
                            <th>${teacher.tno}</th>
                            <th>${teacher.tname}</th>
                            <th>${teacher.tdept}</th>
                            <th>${teacher.ttel}</th>
                            <th>${teacher.temail}</th>
                            <th>${teacher.tcno}</th>
                            <th>${teacher.course.cname}</th>
                            <th>
                                <a onclick="update('${teacher.tno}','${teacher.tname}','${teacher.tdept}','${teacher.ttel}','${teacher.temail}','${teacher.tcno}','${teacher.course.cname}')"><i class="layui-icon layui-icon-edit"></i></a>
                                <a onclick="confirmDel(${teacher.tno})"><i class="layui-icon layui-icon-delete"></i></a>
                            </th>
                        </tr>
                    </c:forEach>
                    </tbody>
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

    function confirmDel(tno) {
        if (window.confirm("您确定要删除这条记录吗")) {
            document.location = "TeacherServlet?option=deleteTeacher&id="+tno;
        }
    }

    function update(tno,tname,tdept,ttel,temail,tcno,tcname){
        layer.open({
            type: 1,
            title:'修改教师',
            content:'<div style="padding: 10px"><form class="layui-form layui-form-pane" action="TeacherServlet">\n' +
                '                <div class="layui-form-item" pane>\n' +
                '                    <label class="layui-form-label">教师姓名</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="name" value="'+tname+'" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input"readonly="readonly">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item" pane>\n' +
                '                    <label class="layui-form-label">院系</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="dept" value="'+tdept+'" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item" pane>\n' +
                '                    <label class="layui-form-label">电话</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="tel" value="'+ttel+'" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item" pane>\n' +
                '                    <label class="layui-form-label">邮箱</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="email" value="'+temail+'" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item" pane>\n' +
                '                    <label class="layui-form-label">所任课程号</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="cno" value="'+tcno+'" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item" pane>\n' +
                '                    <label class="layui-form-label">所任课程</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="cname" value="'+tcname+'" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item">\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>\n' +
                '                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item">\n' +
                '                    <div class="layui-input-block">\n' +
                ' <input style="display: none" type="text" name="tno" value="'+tno+'" required  lay-verify="required"  autocomplete="off" class="layui-input">' +
                ' <input style="display: none" type="text" name="option" value="updateTeacherByManager" required  lay-verify="required"  autocomplete="off" class="layui-input">' +
                '                    </div>\n' +
                '                </div>\n' +
                '            </form> </div>'
        });
    }
    $(function () {
        $("#btn_add").click(function () {
            layer.open({
                title:'增加教师',
                type: 1,
                content: '<form style="margin: 15px " class="layui-form" action="TeacherServlet">\n' +
                    '                    <input style="display: none" type="text" name="option" value="addTeacher">\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">教师号</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="Tno" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">密码</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="password" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">名字</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="Tname" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">院系</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="Tdept" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">电话</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="Ttel"  placeholder="" autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">邮箱</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="Temail" placeholder="" autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">所任课程</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="CCno" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>\n' +
                    '                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                </form>' //这里content是一个普通的String
            });
        })
    })
    $(function () {
        $("#btn_add1").click(function () {
            layer.open({
                title:'查询教师',
                type: 1,
                content: '<form style="margin: 15px " class="layui-form" action="TeacherServlet">\n' +
                    '                    <input style="display: none" type="text" name="option" value="FindTeacher">\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">教师号</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="Tno"    placeholder="" autocomplete="off" class="layui-input" >\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">教师名</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="Tname"    placeholder="" autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">院系</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="Tdept"   placeholder="" autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    // '                    <div class="layui-form-item">\n' +
                    // '                        <label class="layui-form-label">所任课程</label>\n' +
                    // '                        <div class="layui-input-block">\n' +
                    // '                            <input type="text" name="Cno"    placeholder="" autocomplete="off" class="layui-input">\n' +
                    // '                        </div>\n' +
                    // '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>\n' +
                    '                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                </form>' //这里content是一个普通的String
            });
        })
    })

</script>
</body>
</html>
