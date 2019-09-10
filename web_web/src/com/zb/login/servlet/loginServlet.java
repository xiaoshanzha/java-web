package com.zb.login.servlet;

import com.zb.login.beans.User;
import com.zb.login.dao.UserDao;
import com.zb.login.dao.UserDaoImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String Username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(Username+","+password);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();

        UserDao userdao = new UserDaoImp();
        User user = userdao.getUsernameAndPassword(Username,password);
        if(user == null){
           // 请求重定向去往登陆页面
           // response.sendRedirect("login.jsp");

            /*
            * 转发：
            *   先绑定数据
            *   获取转发器
            *   开始转发
            * */
            request.setAttribute("login_msg","用户名或者密码错误!!!");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request,response);
        }else{
           // pw.println("<h1><font color='green'>Login Success! 登录成功<font><h1>");

            //登录用户设置到session中
            HttpSession session = request.getSession();
            session.setAttribute("loginUser",user);

            List<User> users = userdao.selectAllUsers();
            request.setAttribute("users",users);
            request.getRequestDispatcher("main.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
