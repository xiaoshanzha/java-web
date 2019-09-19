<%@ page import="com.bean.Show" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/9/18
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>动态信息</title>
    <style type="text/css">
        td{font-size: 12px;}
        h2{margin: 0px}
    </style>
</head>
<body>
<table align="center"  border="1" height="180" bordercolor="white" bgcolor="black" cellspacing="1">
    <tr bgcolor="white">
        <td align="center" colspan="13">
            <h2>所有动态信息</h2>
        </td>
    </tr>
    <tr align="center" bgcolor="#e1ffc1" >
        <td><b>用户名</b></td>
        <td><b>时间</b></td>
        <td><b>内容</b></td>
        <td><b>类型</b></td>
        <td><b>图1</b></td>
        <td><b>图2</b></td>
        <td><b>图3</b></td>
        <td><b>图4</b></td>
        <td><b>图5</b></td>
        <td><b>图6</b></td>
        <td><b>图7</b></td>
        <td><b>图8</b></td>
        <td><b>图9</b></td>

    </tr>
    <%
        // 获取动态信息集合
        List<Show> list = (List<Show>)request.getAttribute("list");
        // 判断集合是否有效
        if(list == null || list.size() < 1){
            out.print("没有数据！");
        }else{
            // 遍历动态集合中的数据
            for(Show show : list){
    %>
    <tr align="center" bgcolor="white">
        <td><%=show.getUser()%></td>
        <td><%=show.getTime()%></td>
        <td><%=show.getLaosao()%></td>
        <td><%=show.getType()%></td>
        <td><%=show.getImg_0()%></td>
        <td><%=show.getImg_1()%></td>
        <td><%=show.getImg_2()%></td>
        <td><%=show.getImg_3()%></td>
        <td><%=show.getImg_4()%></td>
        <td><%=show.getImg_5()%></td>
        <td><%=show.getImg_6()%></td>
        <td><%=show.getImg_7()%></td>
        <td><%=show.getImg_8()%></td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
