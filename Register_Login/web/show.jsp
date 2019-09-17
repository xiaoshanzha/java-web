<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/9/13
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>

<html>
<head>
    <title>朋友圈</title>
</head>
<body>
    <form action="ShowServlet" method="post" enctype="multipart/form-data">

        用户：<input type="text" name="user">
        <br/>
        牢骚：<input type="text" name="laosao">
        <br/>
        时间：<input type="text" name="time">
        <br/>
        标签：<input type="text" name="type">
        <br/>
        <input type="file" name = "img_0">
        <br/>
        <input type="file" name = "img_1">
        <br/>
        <input type="file" name = "img_2">
        <br/>
        <input type="file" name = "img_3">
        <br/>
        <input type="file" name = "img_4">
        <br/>
        <input type="file" name = "img_5">
        <br/>
        <input type="file" name = "img_6">
        <br/>
        <input type="file" name = "img_7">
        <br/>
        <input type="file" name = "img_8">
        <br/>
        <input type="submit" value="Login">
        <br/>
    </form>

    <form action="ImageUploadServlet" method="post" enctype="multipart/form-data">
        <input type="file" name = "img_0">
        <br/>
        <input type="submit" value="显示图片链接">
        <br/>
    </form>
</body>
</html>
