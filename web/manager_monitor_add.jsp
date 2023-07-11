<%--
  Created by IntelliJ IDEA.
  User: mazhixiu
  Date: 2020/1/6
  Time: 23:57
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

    <div class="layui-body layui-bg-gray" style="padding: 10px">
        <!-- 内容主体区域 -->
        <div class="layui-card">
            <div class="layui-card-header">管理的班级</div>
            <div class="layui-card-body">
                <table class="layui-table">
                    <colgroup>
                        <col width="150">
                        <col width="150">
                        <col width="150">
                    </colgroup>
                    <thead>
                    <tr>
                        <th>班号</th>
                        <th>年级</th>
                        <th>系别</th>
                        <th>专业</th>
                        <th>人数</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${monitors}" var="cls">
                        <tr>
                            <th>${cls.cno}</th>
                            <th>${cls.cgrade}</th>
                            <th>${cls.cdept}</th>
                            <th>${cls.cmajor}</th>
                            <th>${cls.cnum}</th>

                            <th>
                                <a class="updateMonitor" ><i class="layui-icon layui-icon-edit"></i></a>
                                <a href="MonitorsServlet?option=deleteMonitor&id=${cls.cno}"><i class="layui-icon layui-icon-delete"></i></a>
                            </th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <button id="btn_add" class="layui-btn">增加班级</button>
                <button id="btn_add1" class="layui-btn">查询班级</button>
<%--                <input type="button" value="查询班级" οnclick="document.location.href='manager_monitor_find.jsp'"class="layui-btn">--%>

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
    $(function () {
        var clicks =  $(".updateClass");
        for (var i = 0; i < clicks.length; i++) {
            var nodes = $($($(".updateClass").parent()).parent()).children();
            var classId = $(nodes[0]).text();
            $(clicks[i]).click(function () {
                layer.open({
                    type: 1,
                    title:'修改班级',
                    content: '<div style="padding: 10px"><form class="layui-form layui-form-pane" action="MonitorServlet">\n' +
                        '                <div class="layui-form-item" pane>\n' +
                        '                    <label class="layui-form-label">班号</label>\n' +
                        '                    <div class="layui-input-block">\n' +
                        '                        <input type="text" name="Cno" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                        '                    </div>\n' +
                        '                </div>\n' +
                        '                <div class="layui-form-item" pane>\n' +
                        '                    <label class="layui-form-label">初始密码</label>\n' +
                        '                    <div class="layui-input-block">\n' +
                        '                        <input type="text" name="password" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                        '                    </div>\n' +
                        '                </div>\n' +
                        '                <div class="layui-form-item" pane>\n' +
                        '                    <label class="layui-form-label">年级</label>\n' +
                        '                    <div class="layui-input-block">\n' +
                        '                        <input type="text" name="Cgrade" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                        '                    </div>\n' +
                        '                </div>\n' +
                        '                <div class="layui-form-item" pane>\n' +
                        '                    <label class="layui-form-label">系别</label>\n' +
                        '                    <div class="layui-input-block">\n' +
                        '                        <input type="text" name="Cdept" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                        '                    </div>\n' +
                        '                </div>\n' +
                        '                <div class="layui-form-item" pane>\n' +
                        '                    <label class="layui-form-label">专业</label>\n' +
                        '                    <div class="layui-input-block">\n' +
                        '                        <input type="text" name="Cmajor" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                        '                    </div>\n' +
                        '                </div>\n' +
                        '                <div class="layui-form-item" pane>\n' +
                        '                    <label class="layui-form-label">人数</label>\n' +
                        '                    <div class="layui-input-block">\n' +
                        '                        <input type="text" name="Cnum" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
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
                        // ' <input style="display: none" type="text" name="id" value="'+classId+'" required  lay-verify="required"  autocomplete="off" class="layui-input">' +
                        ' <input style="display: none" type="text" name="option" value="addMonitor" required  lay-verify="required"  autocomplete="off" class="layui-input">' +
                        '                    </div>\n' +
                        '                </div>\n' +
                        '            </form> </div>'
                });
            })
        }

    })
    $(function () {
        $("#btn_add1").click(function () {
            layer.open({
                title:'查询班级',
                type: 1,
                content:'<div style="padding: 10px"><form class="layui-form layui-form-pane" action="MonitorServlet">\n' +
                    '                <div class="layui-form-item" pane>\n' +
                    '                    <label class="layui-form-label">班号</label>\n' +
                    '                    <div class="layui-input-block">\n' +
                    '                        <input type="text" name="Cno" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                    '                    </div>\n' +
                    '                </div>\n' +
                    // '                <div class="layui-form-item" pane>\n' +
                    // '                    <label class="layui-form-label">年级</label>\n' +
                    // '                    <div class="layui-input-block">\n' +
                    // '                        <input type="text" name="Cgrade" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                    // '                    </div>\n' +
                    // '                </div>\n' +
                    //
                    // '                <div class="layui-form-item" pane>\n' +
                    // '                    <label class="layui-form-label">专业</label>\n' +
                    // '                    <div class="layui-input-block">\n' +
                    // '                        <input type="text" name="Cmajor" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                    // '                    </div>\n' +
                    // '                </div>\n' +

                    '                <div class="layui-form-item">\n' +
                    '                    <div class="layui-input-block">\n' +
                    '                        <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>\n' +
                    '                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>\n' +
                    '                    </div>\n' +
                    '                </div>\n' +
                    '                <div class="layui-form-item">\n' +
                    '                    <div class="layui-input-block">\n' +
                    // ' <input style="display: none" type="text" name="id" value="'+classId+'" required  lay-verify="required"  autocomplete="off" class="layui-input">' +
                    ' <input style="display: none" type="text" name="option" value="FindMonitorByCno" required  lay-verify="required"  autocomplete="off" class="layui-input">' +
                    '                    </div>\n' +
                    '                </div>\n' +
                    '            </form> </div>'

            });
        })
    })
    $(function () {
        $("#btn_add").click(function () {
            layer.open({
                title:'增加班级',
                type: 1,
                content:'<div style="padding: 10px"><form class="layui-form layui-form-pane" action="MonitorServlet">\n' +
                    '                <div class="layui-form-item" pane>\n' +
                    '                    <label class="layui-form-label">班号</label>\n' +
                    '                    <div class="layui-input-block">\n' +
                    '                        <input type="text" name="Cno" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                    '                    </div>\n' +
                    '                </div>\n' +
                    '                <div class="layui-form-item" pane>\n' +
                    '                    <label class="layui-form-label">初始密码</label>\n' +
                    '                    <div class="layui-input-block">\n' +
                    '                        <input type="text" name="password" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                    '                    </div>\n' +
                    '                </div>\n' +
                    '                <div class="layui-form-item" pane>\n' +
                    '                    <label class="layui-form-label">年级</label>\n' +
                    '                    <div class="layui-input-block">\n' +
                    '                        <input type="text" name="Cgrade" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                    '                    </div>\n' +
                    '                </div>\n' +
                    '                <div class="layui-form-item" pane>\n' +
                    '                    <label class="layui-form-label">系别</label>\n' +
                    '                    <div class="layui-input-block">\n' +
                    '                        <input type="text" name="Cdept" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                    '                    </div>\n' +
                    '                </div>\n' +
                    '                <div class="layui-form-item" pane>\n' +
                    '                    <label class="layui-form-label">专业</label>\n' +
                    '                    <div class="layui-input-block">\n' +
                    '                        <input type="text" name="Cmajor" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
                    '                    </div>\n' +
                    '                </div>\n' +
                    '                <div class="layui-form-item" pane>\n' +
                    '                    <label class="layui-form-label">人数</label>\n' +
                    '                    <div class="layui-input-block">\n' +
                    '                        <input type="text" name="Cnum" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">\n' +
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
                    // ' <input style="display: none" type="text" name="id" value="'+classId+'" required  lay-verify="required"  autocomplete="off" class="layui-input">' +
                    ' <input style="display: none" type="text" name="option" value="addMonitor" required  lay-verify="required"  autocomplete="off" class="layui-input">' +
                    '                    </div>\n' +
                    '                </div>\n' +
                    '            </form> </div>'

            });
        })
    })

</script>
</body>
</html>


