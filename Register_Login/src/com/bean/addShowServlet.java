package com.bean;

import com.bean.dao.UserDao;
import com.bean.dao.UserDaoImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

        UserDao userDao = new UserDaoImp();
        userDao.insertShow(text,img_url);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
