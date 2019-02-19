<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/4
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js" ></script>
    <script>
        $(function () {
            $.post("user/getAddress",function (data) {
                var html = $("#zfs").html();
                html+=`<h3>已有文件列表</h3>`;
                $("#zfs").html(html);
            },"json");
        })
    </script>
</head>

<body>

    <h3>传统文件上传</h3>

    <form action="user/fileupload1" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="upload"><br/>
        <input type="submit" value="上传">
    </form>

    <h3>MVC文件上传</h3>

    <form action="user/fileupload2" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="upload"><br/>
        <input type="submit" value="上传">
    </form>

    <h3>已有文件列表</h3>
    <div id="zfs"></div>

    <h3>测试异常</h3>
    <a href="user/testExp">testExp</a>
    <h3>测试拦截器</h3>
    <a href="user/testInterceptor">testInterceptor</a>
</body>
</html>
