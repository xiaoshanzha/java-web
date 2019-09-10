<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/9/8
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- jsp页面执行原理：
        jsp质上就是一个Servlet. 执行的时候会先在转化成一个.java文件，再编译成.class文件.
        转化规则：Java代码片段照搬，html、css、js等通过输出流 out.writer()方法往出写
     jsp作用：
        可以自动的将html相关的代码通过流写到浏览器端.
        支持写java代码，可以灵活的做出一些处理.
-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <style>
        span{
            color:red;
        }
    </style>
    <title>登陆</title>
    <style>
        body{
            background-color: pink;
        }
    </style>
    <script type="text/javascript">
        function clearLoginMsg() {
            var spanEle = document.getElementById("login_span");
            spanEle.innerHTML="";
        }
    </script>
</head>
<!--<body bgcolor="pink">-->
<body>
    <h1>欢迎登陆</h1>

    <!--两种java代码：
        1.java片段
        2.表达式
    -->
    <!--java片段-->
    <%
        String str = "aaa";
        System.out.println(str);
    %>
    <!--表达式
        <%=5>3?"大于":"小于"%>
    -->



    <form action="login"method="post">
        <!--鼠标点击调用clearLoginMsg()方法-->
        用户名称：<input type="text" name="username" onfocus="clearLoginMsg();">
        <!-- EL表达式进行提示-->
        <span id = "login_span">${requestScope.login_msg}</span>

        <!--
             <%
                //获取到request对象:  request对象可以直接用
                String loginMsg = (String) request.getAttribute("login_msg");
              %>
              <span><%=loginMsg==null?"":loginMsg%></span>
        -->

        <br/>
        用户密码：<input type="password" name="password">
        <br/>
        <input type="submit" value="Login">
        <br/>
    </form>
</body>
</html>
