package com.bean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/GetNewsOneServlet")
public class GetNewsOneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("Text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // 实例化List对象
        List<NewsOne> list = new ArrayList<NewsOne>();
        try {
            // 加载数据库驱动，注册到驱动管理器
            Class.forName("com.mysql.cj.jdbc.Driver");
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
            String sql = "select * from news1";
            // 执行查询
            ResultSet rs = stmt.executeQuery(sql);

            // 判断光标向后移动，并判断是否有效
            while(rs.next()){
                NewsOne newsOne = new NewsOne();
                newsOne.setTopic(rs.getString("topic"));
                newsOne.setAuthor(rs.getString("author"));
                newsOne.setTime(rs.getString("time"));
                newsOne.setImg_url(rs.getString("img_url"));
                newsOne.setMain_url(rs.getString("main_url"));
                newsOne.setContent(rs.getString("content"));
                list.add(newsOne);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(int i = 0;i<list.size();i++){
            out.println(i+1);
            out.println(list.get(i).author);
            out.println(list.get(i).time);
            out.println(list.get(i).topic);
            out.println(list.get(i).content);
            out.println(list.get(i).img_url);
            out.println(list.get(i).main_url);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
