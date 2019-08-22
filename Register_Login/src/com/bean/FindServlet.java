package com.bean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/FindServlet")
public class FindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            // 加载数据库驱动，注册到驱动管理器
            Class.forName("com.mysql.jdbc.Driver");
            // 数据库连接字符串
            String url = "jdbc:mysql://localhost:3306/mydatabase?&serverTimezone=UTC";
            // 数据库用户名
            String username = "root";
            // 数据库密码
            String password = "1234";
            // 创建Connection连接
            Connection conn = DriverManager.getConnection(url,username,password);
            // 获取Statement
            Statement stmt = conn.createStatement();
            // 添加图书信息的SQL语句
            String sql = "select * from users";
            // 执行查询
            ResultSet rs = stmt.executeQuery(sql);
            // 实例化List对象
            List<User> list = new ArrayList<User>();
            // 判断光标向后移动，并判断是否有效
            while(rs.next()){
                // 实例化User对象
                User user = new User();
                // 对id属性赋值
                user.setId(rs.getString("id"));
                // 对password属性赋值
                user.setPassword(rs.getString("password"));
                // 将图书对象添加到集合中
                list.add(user);
            }
            // 将图书集合放置到request之中
            request.setAttribute("list", list);
            rs.close();		// 关闭ResultSet
            stmt.close();	// 关闭Statement
            conn.close();	// 关闭Connection
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 请求转发到book_list.jsp
        request.getRequestDispatcher("user_list.jsp").forward(request, response);
    }
}
