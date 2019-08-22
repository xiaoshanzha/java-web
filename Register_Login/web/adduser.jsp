<%@ page import="com.bean.User" %>
<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/8/18
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="user" class="com.bean.User"/>
<jsp:setProperty property="*" name="user"/>
<%
    try {
        // 加载数据库驱动，注册到驱动管理器
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 数据库连接字符串
        String url = "jdbc:mysql://localhost:3306/mydatabase?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
        // 数据库用户名
        String username = "root";
        // 数据库密码
        String password = "1234";
        // 创建Connection连接
        Connection conn = DriverManager.getConnection(url,username,password);

        //判断用户是否存在
        boolean type = false;
        int len = user.getPassword().length();
        String sql_t = "select * from users where id='"+user.getId()+"'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql_t);
        while (rs.next()){
            type = true;
        }
        //用户不存在，且注册账号id不为空。密码大于6位，则成功注册
        if(!type && len>=6 && !(user.getId().isEmpty())){
            // 添加图书信息的SQL语句
            String sql = "insert into users(id,password) values(?,?)";
            // 获取PreparedStatement
            PreparedStatement ps = conn.prepareStatement(sql);
            // 对SQL语句中的第1个参数赋值
            ps.setString(1, user.getId());
            // 对SQL语句中的第2个参数赋值
            ps.setString(2, user.getPassword());
            // 执行更新操作，返回所影响的行数
            int row = ps.executeUpdate();
            // 判断是否更新成功
            if(row > 0){
                // 更新成输出信息
                out.println("注册成功！ " );
            }
            // 关闭PreparedStatement，释放资源
            ps.close();
            // 关闭Connection，释放资源
            conn.close();
        }else if(type)
        {
            out.println("该用户已经存在，请重新注册");
        }else if(len<6 && !type){
            out.println("注册失败，请输入大于6位数的密码");
        }

    } catch (Exception e) {
        out.print("用户信息添加失败！");
        e.printStackTrace();
    }
%>
</body>
</html>
