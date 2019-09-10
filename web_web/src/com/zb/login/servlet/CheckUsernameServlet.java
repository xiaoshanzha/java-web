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

@WebServlet("/CheckUsernameServlet")
public class CheckUsernameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取到用户名
        String username = request.getParameter("username");

        UserDao userDao = new UserDaoImp();

        User user = userDao.getUserByUsername(username);

        String msg = "";
        if(user == null ) {
            //可用
            msg = "0";
        }else {
            //不可用
            msg = "1";
        }

        response.setContentType("text/html;charset=utf-8");

        response.getWriter().println(msg);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
