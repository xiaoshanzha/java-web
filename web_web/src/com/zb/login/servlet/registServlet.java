package com.zb.login.servlet;

import com.zb.login.beans.User;
import com.zb.login.dao.UserDao;
import com.zb.login.dao.UserDaoImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registServlet")
public class registServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取用户提交的注册信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //判断用户名是否可用
        UserDao userdao = new UserDaoImp();

        User user = userdao.getUserByUsername(username);
        if(user!=null){
            //注册失败，回到注册页面，进行相应提示；
            //进行转发
            request.setAttribute("regist_msg","用户名已经存在！");
            request.getRequestDispatcher("regist.jsp").forward(request,response);
        }else{
            userdao.insertUser(username,password);
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
