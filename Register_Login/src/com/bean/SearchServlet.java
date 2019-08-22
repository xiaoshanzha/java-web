package com.bean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID = request.getParameter("ID");
        String PW = request.getParameter("PW");
        boolean type = false;

        response.setContentType("Text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // 加载数据库驱动，注册到驱动管理器
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 数据库连接字符串
        String url = "jdbc:mysql://localhost:3306/mydatabase?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
        // 数据库用户名
        String username = "root";
        // 数据库密码
        String password = "1234";
        // 创建Connection连接
        try {
            Connection conn = DriverManager.getConnection(url,username,password);
            Statement stmt = conn.createStatement();
            String sql = "select * from users where id='"+ID+"' and password='"+PW+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                type = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            out.println(e.getMessage());
        }finally {
            out.print(type);
            out.flush();
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
