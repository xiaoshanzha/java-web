<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/9/7
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <title>My First Jsp Page</title>
    <style type="text/css">
      #d1{
        width:200px;
        height:200px;
        background-color:red ;
      }
    </style>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"> </script>
    <script type="text/javascript">
      function clickButton(){
        window.alert("点击了");

        //获取span内容，替换，将原内容显示在文本框
        var spanEle = window.document.getElementById("s1");
        var msg = spanEle.innerHTML;
        spanEle.innerHTML = "67890";

        document.getElementById("i1").value = msg;
      }
      function mouseOver() {
        alert("鼠标进来了");
      }
      function mouseOut(){
        alert("鼠标出去了");
      }

      $(function () {
        alert("文档加载完毕了");
      });
    </script>
  </head>
  <body>
  <!--EL表达式-->
  ${1+1}
  <br/>
  ${2>3}
  <br/>
  ${!empty a} //空值判断
  <br/>

  <input type="button" value="点击" onclick="clickButton();">

  <div id="d1" onmouseover="mouseOver();" onmouseout="mouseOut();"></div>

  <span id="s1">12345</span>
  <br/>
  <input id="i1" type="text" />

  <br/>
  <a href="CookieServlet">Test Cookie</a>

  </body>
</html>
