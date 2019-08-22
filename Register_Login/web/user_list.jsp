<%@ page import="com.bean.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/8/18
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>users信息</title>
    <style type="text/css">
        td{font-size: 12px;}
        h2{margin: 0px}
    </style>
</head>
<body>
<table align="center" width="450" border="1" height="180" bordercolor="white" bgcolor="black" cellpadding="1" cellspacing="1">
    <tr bgcolor="white">
        <td align="center" colspan="5">
            <h2>所有用户信息</h2>
        </td>
    </tr>
    <tr align="center" bgcolor="#e1ffc1" >
        <td><b>ID</b></td>
        <td><b>password</b></td>
    </tr>
    <%
        // 获取图书信息集合
        List<User> list = (List<User>)request.getAttribute("list");
        // 判断集合是否有效
        if(list == null || list.size() < 1){
            out.print("没有数据！");
        }else{
            // 遍历图书集合中的数据
            for(User user : list){
    %>
    <tr align="center" bgcolor="white">
        <td><%=user.getId()%></td>
        <td><%=user.getPassword()%></td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
