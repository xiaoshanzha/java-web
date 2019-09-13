<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/9/13
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试</title>
</head>
<body>
    <form action="tempServlet" method="post" enctype="multipart/form-data">
        <!--鼠标点击调用clearLoginMsg()方法-->
        用户名称：<input type="text" name="username" onfocus="clearLoginMsg();">
        <br/>
        用户密码：<input type="password" name="password">
        <br/>
        头像：<input type="file" name = "img_0">
        <br/>
        头像：<input type="file" name = "img_1">
        <br/>
        头像：<input type="file" name = "img_2">
        <input type="submit" value="Login">
        <br/>
    </form>
</body>
</html>
