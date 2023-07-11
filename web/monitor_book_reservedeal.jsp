<%--
  Created by IntelliJ IDEA.
  User: mazhixiu
  Date: 2020/1/6
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.javaweb.demo.entity.Monitor" %>
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
                    ${sessionScope.user.cno}
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
                    <a class="" href="javascript:;"><i class="layui-icon layui-icon-user"></i> 预定管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="BookServlet?option=showAllBooksToMonitor">教材预定</a></dd>
                        <dd><a href="ReserveServlet?option=showReserveMonitor">预定列表</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon layui-icon-template-1"></i> 个人信息</a>
                    <dl class="layui-nav-child">
                        <dd><a href="monitor_modify_info.jsp?">修改信息</a></dd>
                        <dd><a href="monitor_modify_pwd.jsp?">修改密码</a></dd>
                    </dl>
                </li>
            </ul>

            <div class="layui-body layui-bg-gray" style="padding: 10px">
                <!-- 内容主体区域 -->
                <div class="layui-card">
                    <div class="layui-card-header">全部预定</div>
                    <div class="layui-card-body">
                        <table class="layui-table">
                            <colgroup>
                                <col>
                            </colgroup>
                            <thead>
                            <tr>
                                <th>预定号</th>
                                <th>书号</th>
                                <th>书名</th>
                                <td>数量</td>
                                <td>订单总价</td>
                                <td>订单日期</td>
                                <th>订单状态</th>
                                <th>领书地点</th>
                                <th>领书时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>

                            <c:forEach var="bookReserve" items="${Reserves}">
                                <tr>
                                    <td>${bookReserve.id}</td>
                                    <td>${bookReserve.book.bno}</td>
                                    <td>${bookReserve.book.bname}</td>
                                    <td>${bookReserve.num}</td>
                                    <td>${bookReserve.totalPrice}</td>
                                    <td>${bookReserve.r_time}</td>
                                    <td>${bookReserve.bstatus}</td>
                                    <td>${bookReserve.place}</td>
                                    <td>${bookReserve.q_time}</td>

                                    <td>
                                        <a  onclick="update('${bookReserve.id}','${bookReserve.book.bno}','${bookReserve.book.bname}','${bookReserve.num}',' ${sessionScope.user.cno}')"><i class="layui-icon layui-icon-edit"></i></a>
                                        <a onclick="confirmDel(${bookReserve.id})" ><i class="layui-icon layui-icon-delete"></i></a>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                        <button id="btn_find" class="layui-btn" onclick="" >查询教材</button>

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
    function confirmDel(id) {
        if (window.confirm("您确定要删除这条记录吗")) {
            document.location = "ReserveServlet?option=deleteReserve&id="+id;
        }
    }
    function update(ID,Bno,Bname,Rnum,Cno) {
        layer.open({
            type: 1,
            title:'修改预定',
            content:'<div style="padding: 10px"><form class="layui-form layui-form-pane" action="ReserveServlet">\n' +
                '                <div class="layui-form-item" pane>\n' +
                '                    <label class="layui-form-label">班号</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="cno" value="'+Cno+'" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" readonly="readonly">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item" pane>\n' +
                '                    <label class="layui-form-label">书号</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="bno" value="'+Bno+'" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" readonly="readonly">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item" pane>\n' +
                '                    <label class="layui-form-label">书名</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="bname" value="'+Bname+'" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" readonly="readonly">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item" pane>\n' +
                '                    <label class="layui-form-label">预定数量</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="rnum" value="'+Rnum+'" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" >\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item">\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <button class="layui-btn" lay-submit lay-filter="formDemo">立即预定</button>\n' +
                '                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item">\n' +
                '                    <div class="layui-input-block">\n' +
                ' <input style="display: none" type="text" name="id" value="'+ID+'" required  lay-verify="required"  autocomplete="off" class="layui-input">' +
                ' <input style="display: none" type="text" name="option" value="updateReserveByMonitor" required  lay-verify="required"  autocomplete="off" class="layui-input">' +
                '                    </div>\n' +
                '                </div>\n' +
                '            </form> </div>'
        });
    }




</script>
</body>
</html>

