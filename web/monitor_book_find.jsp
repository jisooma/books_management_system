<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/9
  Time: 15:03
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
        </div>
    </div>

    <div class="layui-body layui-bg-gray" style="padding: 10px">
        <!-- 内容主体区域 -->
        <div class="layui-card">
            <div class="layui-card-header">教材列表</div>
            <div class="layui-card-body">

                <button id="btn_find" class="layui-btn" onclick="" >查询教材</button>

                <table class="layui-table">
                    <colgroup>
                        <col width="150">
                        <col width="200">
                        <col>
                    </colgroup>
                    <thead>
                    <tr>
                        <th>教材号</th>
                        <th>教材名</th>
                        <th>作者</th>
                        <th>出版社</th>
                        <th>版次</th>
                        <th>价格</th>
                        <th>数量</th>
                        <th>所属课程</th>
                        <th>任课老师</th>
                        <th>预定</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${books}" var="book">
                        <tr>
                            <th>${book.bno}</th>
                            <th>${book.bname}</th>
                            <th>${book.bauthor}</th>
                            <th>${book.bsource}</th>
                            <th>${book.bedition}</th>
                            <th>${book.bprice}</th>
                            <th>${book.bnum}</th>
                            <th>${book.course.cname}</th>
                            <th>${book.teacher.tname}</th>
                            <th>
                                <a  onclick="reserve('${book.bno}','${book.bname}','${book.bauthor}','${book.bsource}',' ${book.bedition}','${book.bprice}','${book.bnum}','${book.course.cname}','${book.teacher.tname}','${sessionScope.user.cno}')"><i class="layui-icon layui-icon-edit"></i></a>
                                    <%--                                <a  onclick="reserve('${book.bno}','${book.bname}','${book.bauthor}','${book.bsource}',' ${book.bedition}','${book.bprice}','${book.bnum}','${book.course.cname}','${book.teacher.tname}','${sessionScope.user.cno}')"></a>--%>
                            </th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <%--                <button id="btn_find" class="layui-btn" onclick="" >查询教材</button>--%>
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
    function reserve(Bno,Bname,Bauthor,Bsource,Bedition,Bprice,Bnum,Cname,Tname,Cno) {
        layer.open({
            type: 1,
            title:'预定教材',
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
                '                    <label class="layui-form-label">作者</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="bauthor" value="'+Bauthor+'" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" readonly="readonly">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item" pane>\n' +
                '                    <label class="layui-form-label">出版社</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="bsource" value="'+Bsource+'" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" readonly="readonly">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item" pane>\n' +
                '                    <label class="layui-form-label">版次</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="" value="'+Bedition+'" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" readonly="readonly">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item" pane>\n' +
                '                    <label class="layui-form-label">价格</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="" value="'+Bprice+'" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" readonly="readonly">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item" pane>\n' +
                '                    <label class="layui-form-label">库存量</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="" value="'+Bnum+'" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" readonly="readonly">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item" pane>\n' +
                '                    <label class="layui-form-label">所属课程</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="" value="'+Cname+'" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" readonly="readonly">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item" pane>\n' +
                '                    <label class="layui-form-label">录入教师</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="" value="'+Tname+'" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" readonly="readonly">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item" pane>\n' +
                '                    <label class="layui-form-label">预定数量</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="rnum" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" >\n' +
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
                ' <input style="display: none" type="text" name="option" value="addReserve" required  lay-verify="required"  autocomplete="off" class="layui-input">' +
                '                    </div>\n' +
                '                </div>\n' +
                '            </form> </div>'
        });
    }

    $(function () {
        $("#btn_find").click(function () {
            layer.open({
                title:'查询教材',
                type: 1,
                content: '<form style="margin: 15px " class="layui-form" action="BookServlet">\n' +
                    '                    <input style="display: none" type="text" name="option" value="MonitorfindBook">\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">教材号</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="bno"    placeholder="" value=" " autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">教材名</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="bname"    placeholder="" value="" autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">录入老师</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="tno"   placeholder="" value="" autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">所属课程</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="cno"   placeholder="" value="" autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <button class="layui-btn" lay-submit lay-filter="formDemo">查询</button>\n' +
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