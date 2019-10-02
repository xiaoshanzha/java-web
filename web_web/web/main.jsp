<%@ page import="com.zb.login.beans.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/9/10
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
</head>
<body>
    <h1 align="center">欢迎
        <font color="blue">${sessionScope.loginUser.username}</font>
        登陆
    </h1>
    <h2 align="center">用户信息列表</h2>
    <br>
    <table border="1px" width="70%" align="center" cellspacing="0px">
        <tr>
            <th>ID</th>
            <th>UserName</th>
            <th>password</th>
            <th>Operation</th>
        </tr>

        <!-- 通过循环 显示 员工数据 -->
        <!--
            c:forEach  循环 迭代
                items: 指定要迭代的集合
                var: 代表当前迭代出的元素
         -->
        <c:forEach items="${users}" var="user">
            <tr align="center">
                <td>${user.id}</td>
                <td>${user.username}</td>
                <fmt:td>${user.password}</fmt:td bundle>
                <td></td>
                <td></td>
                <td>
                    <a href="#">Edit</a>
                    <a href="#">Delete</a>
                </td>
            </tr>
        </c:forEach>
        <%--
            <%
                //获取所有的员工数据
                List<User> users =(List<User> )request.getAttribute("users");

                for(User user :users ){
            %>
            <tr align="center">
                <td><%=user.getId() %></td>
                <td><%=user.getUsername() %></td>
                <td><%=user.getPassword() %></td>
                <td>
                    <a href="#">Edit</a>
                    <a href="#">Delete</a>
                </td>
            </tr>
            <%
                }
            %>
        --%>
    </table>
</body>
</html>
