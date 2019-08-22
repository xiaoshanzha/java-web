<%@ page import="javafx.print.Printer" %>
<%@ page import="com.bean.*, java.util.*, java.io.*" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/8/18
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>欢迎</title>
</head>
<body>
<form action="adduserServlet" method="post" onsubmit="return check(this);">
    <table align="center" width="450">
        <tr>
            <td align="center" colspan="2">
                <h2>输入用户信息</h2>
                <hr>
            </td>
        </tr>
        <tr>
            <td align="right">账   号：</td>
            <td><input type="text" name="id" /></td>
        </tr>
        <tr>
            <td align="right">密   码：</td>
            <td><input type="text" name="password" /></td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <input type="submit" value="注  册">
            </td>
        </tr>
    </table>
</form>
<form action="SearchServlet" method="post" onsubmit="return check(this);">
    <table align="center" width="450">
        <tr>
            <td align="center" colspan="2">
                <h2>输入用户信息</h2>
                <hr>
            </td>
        </tr>
        <tr>
            <td align="right">账   号：</td>
            <td><input type="text" name="ID" /></td>
        </tr>
        <tr>
            <td align="right">密   码：</td>
            <td><input type="text" name="PW" /></td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <input type="submit" value="登陆">
            </td>
        </tr>
    </table>
</form>
<a href="FindServlet">查看所有信息</a>>
</body>
</html>

