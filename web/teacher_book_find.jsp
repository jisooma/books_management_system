<%--
  Created by IntelliJ IDEA.
  User: mazhixiu
  Date: 2020/1/8
  Time: 17:55
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
            <div class="layui-card-header">教材列表</div>

            <div class="layui-card-body">
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
                        <th>操作</th>
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
                            <th>
                                <a onclick="update('${book.bname}','${book.bauthor}','${book.bsource}','${book.bedition}','${book.bprice}','${book.bno}','${book.ccno}')"><i class="layui-icon layui-icon-edit"></i></a>
                                <a onclick="confirmDel(${book.bno})" ><i class="layui-icon layui-icon-delete"></i></a>
                            </th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

<%--                &lt;%&ndash;            靠右&ndash;%&gt;--%>
<%--                <button id="btn_find" class="layui-btn" style="float:right" onclick="">查询教材</button>--%>

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

    function confirmDel(param) {
        if (window.confirm("您确定要删除该教材吗")) {
            document.location = "BookServlet?option=deleteBook&Bno=" + param;
        }
    }

    function update(bookName,bookAuthor,bookSource,bookEdition,bookPrice,bookBno,bookCcno) {
        layer.open({
            type: 1,
            title:'修改书籍',
            content:'<div style="padding: 10px"><form class="layui-form layui-form-pane" action="BookServlet">\n' +
                '                <div class="layui-form-item" pane>\n' +
                '                    <label class="layui-form-label">书名</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="name" required lay-verify="required" value="'+bookName+'" autocomplete="off" class="layui-input">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item" pane>\n' +
                '                    <label class="layui-form-label">作者</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="author" required lay-verify="required" value="'+bookAuthor+'" autocomplete="off" class="layui-input">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item" pane>\n' +
                '                    <label class="layui-form-label">出版社</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="source" required lay-verify="required" value="'+bookSource+'" autocomplete="off" class="layui-input">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item" pane>\n' +
                '                    <label class="layui-form-label">版次</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="edition" required lay-verify="required" value="'+bookEdition+'" autocomplete="off" class="layui-input">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item" pane>\n' +
                '                    <label class="layui-form-label">价格</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="price" required lay-verify="required" value="'+bookPrice+'" autocomplete="off" class="layui-input">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item" pane>\n' +
                '                    <label class="layui-form-label">所属课程号</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" name="ccno" required lay-verify="required" value="'+bookCcno+'" autocomplete="off" class="layui-input">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                // '                <div class="layui-form-item" pane>\n' +
                // '                    <label class="layui-form-label">数量</label>\n' +
                // '                    <div class="layui-input-block">\n' +
                // '                        <input type="text" name="number" required lay-verify="required" value="'+bookNumber+'" autocomplete="off" class="layui-input">\n' +
                // '                    </div>\n' +
                // '                </div>\n'+
                '                <div class="layui-form-item">\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>\n' +
                '                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-form-item">\n' +
                '                    <div class="layui-input-block">\n' +
                ' <input style="display: none" type="text" name="Bno" value="'+bookBno+'" required  lay-verify="required"  autocomplete="off" class="layui-input">' +
                ' <input style="display: none" type="text" name="option" value="updateBook" required  lay-verify="required"  autocomplete="off" class="layui-input">' +
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
                    '                    <input style="display: none" type="text" name="option" value="findBook">\n' +
                    '                    <div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">教材号</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="Bno"    placeholder="" autocomplete="off" class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    // '                    <div class="layui-form-item">\n' +
                    // '                        <label class="layui-form-label">教材名</label>\n' +
                    // '                        <div class="layui-input-block">\n' +
                    // '                            <input type="text" name="Bname"    placeholder="" autocomplete="off" class="layui-input">\n' +
                    // '                        </div>\n' +
                    // '                    </div>\n' +
                    // '                    <div class="layui-form-item">\n' +
                    // '                        <label class="layui-form-label">作者</label>\n' +
                    // '                        <div class="layui-input-block">\n' +
                    // '                            <input type="text" name="Bauthor"   placeholder="" autocomplete="off" class="layui-input">\n' +
                    // '                        </div>\n' +
                    // '                    </div>\n' +
                    // '                    <div class="layui-form-item">\n' +
                    // '                        <label class="layui-form-label">出版社</label>\n' +
                    // '                        <div class="layui-input-block">\n' +
                    // '                            <input type="text" name="Bsource"    placeholder="" autocomplete="off" class="layui-input">\n' +
                    // '                        </div>\n' +
                    // '                    </div>\n' +
                    // '                    <div class="layui-form-item">\n' +
                    // '                        <label class="layui-form-label">版次</label>\n' +
                    // '                        <div class="layui-input-block">\n' +
                    // '                            <input type="text" name="Bedition"   placeholder="" autocomplete="off" class="layui-input">\n' +
                    // '                        </div>\n' +
                    // '                    </div>\n' +
                    // '                    <div class="layui-form-item">\n' +
                    // '                        <label class="layui-form-label">课程号</label>\n' +
                    // '                        <div class="layui-input-block">\n' +
                    // '                            <input type="text" name="CCno"   placeholder="" autocomplete="off" class="layui-input">\n' +
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