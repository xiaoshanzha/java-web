package com.bean;

import com.bean.utils.ConnectionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AllShowServlet")
public class AllShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            String sql = "select * from shows";
            // 执行查询
            ResultSet rs = stmt.executeQuery(sql);
            // 实例化List对象
            List<Show> list = new ArrayList<Show>();
            // 判断光标向后移动，并判断是否有效
            while(rs.next()){
                Show show = new Show();
                show.setUser(rs.getString("user"));
                show.setTime(rs.getString("time"));
                show.setLaosao(rs.getString("text"));
                show.setType(rs.getString("type"));
                show.setImg_0(rs.getString("img_0"));
                show.setImg_1(rs.getString("img_1"));
                show.setImg_2(rs.getString("img_2"));
                show.setImg_3(rs.getString("img_3"));
                show.setImg_4(rs.getString("img_4"));
                show.setImg_5(rs.getString("img_5"));
                show.setImg_6(rs.getString("img_6"));
                show.setImg_7(rs.getString("img_7"));
                show.setImg_8(rs.getString("img_8"));
                list.add(show);
            }
            // 将动态集合放置到request之中
            request.setAttribute("list", list);
            rs.close();		// 关闭ResultSet
            stmt.close();	// 关闭Statement
            conn.close();	// 关闭Connection
        }  catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 请求转发到book_list.jsp
        request.getRequestDispatcher("show_list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
