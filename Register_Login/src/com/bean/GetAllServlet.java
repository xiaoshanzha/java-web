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

@WebServlet("/GetAllServlet")
public class GetAllServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("Text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // 实例化List对象
        List<Dyn> list = new ArrayList<Dyn>();
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
            String sql = "select * from shows";
            // 执行查询
            ResultSet rs = stmt.executeQuery(sql);

            // 判断光标向后移动，并判断是否有效
            while(rs.next()){
                Dyn dyn = new Dyn();
                dyn.setUser(rs.getString("user"));
                dyn.setTime(rs.getString("time"));
                dyn.setLaosao(rs.getString("text"));
                dyn.setType(rs.getString("type"));
                for(int i = 0;i<9;i++){
                    String temp = rs.getString("img_"+String.valueOf(i));
                    if(temp.equals("")){
                        dyn.setImg_num(i);
                        break;
                    }else if(i==8&&!temp.equals("")){
                        dyn.setImg_num(9);
                        dyn.url.add(temp);
                        break;
                    }else {
                        dyn.url.add(temp);
                    }
                }
                list.add(dyn);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(int i = 0;i<list.size();i++){
            out.println(list.get(i).user);
            out.println(list.get(i).laosao);
            out.println(list.get(i).time);
            out.println(list.get(i).type);
            out.println(String.valueOf(list.get(i).img_num));
            for(int j = 0;j<list.get(i).img_num;j++){
                out.println( list.get(i).url.get(j));
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
