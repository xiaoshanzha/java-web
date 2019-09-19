package com.bean;

import com.bean.dao.UserDao;
import com.bean.dao.UserDaoImp;
import com.bean.utils.ConnectionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/addShowServlet")
public class addShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("Text/html;charset=UTF-8");

        String[] text = new String[5];
        String[] img_url = new String[10];

        text[0] = new String(request.getParameter("user").getBytes("ISO-8859-1"),"UTF-8");
        text[1] = new String(request.getParameter("time").getBytes("ISO-8859-1"),"UTF-8");
        text[2] = new String(request.getParameter("laosao").getBytes("ISO-8859-1"),"UTF-8");
        text[3] = new String(request.getParameter("type").getBytes("ISO-8859-1"),"UTF-8");

        img_url[0] = request.getParameter("img_0");
        img_url[1] = request.getParameter("img_1");
        img_url[2] = request.getParameter("img_2");
        img_url[3]= request.getParameter("img_3");
        img_url[4] = request.getParameter("img_4");
        img_url[5] = request.getParameter("img_5");
        img_url[6] = request.getParameter("img_6");
        img_url[7] = request.getParameter("img_7");
        img_url[8] = request.getParameter("img_8");
        System.out.println(text[3]);
        System.out.println(text[0]);


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
            String sql = "insert into shows (user,time,text,type,img_0,img_1,img_2,img_3,img_4,img_5,img_6,img_7,img_8) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,text[0]);
            ps.setString(2,text[1]);
            ps.setString(3,text[2]);
            ps.setString(4,text[3]);
            ps.setString(5,img_url[0]);
            ps.setString(6,img_url[1]);
            ps.setString(7,img_url[2]);
            ps.setString(8,img_url[3]);
            ps.setString(9,img_url[4]);
            ps.setString(10,img_url[5]);
            ps.setString(11,img_url[6]);
            ps.setString(12,img_url[7]);
            ps.setString(13,img_url[8]);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        UserDao userDao = new UserDaoImp();
        userDao.insertShow(text,img_url);
        */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
