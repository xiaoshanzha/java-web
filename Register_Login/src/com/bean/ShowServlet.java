package com.bean;

import com.bean.dao.UserDao;
import com.bean.dao.UserDaoImp;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //获取数据

        String[] text = new String[5];
        String[] img_url = new String[10];
        for(int k = 0;k<10;k++){
            img_url[k]="";
        }
        int i = 0;
        int j = 0;
        //保存路径
        String savePath = getServletContext().getRealPath("//imgs//");
        String finalPath = "http:\\101.37.79.26:8080\\show\\imgs\\";
     //   String savePath = "F:\\Tomcat\\webapps\\twoweb\\img\\";

        // 创建文件上传核心类
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(factory);
        //设置编码
        sfu.setHeaderEncoding("UTF-8");

        try {
            List<FileItem> itemList = sfu.parseRequest(request);
            for(FileItem fileItem : itemList){
                String fieldName = fileItem.getFieldName();
                if(!fileItem.isFormField()){
                    String fileName = fileItem.getName();
                    File file = new File(savePath,fileName);
                    if(!fileName.isEmpty()){
                        String temp_url = finalPath+fileName;
                        img_url[j++] = temp_url;
                        fileItem.write(file);
                    }
                }else {
                    String temp = fileItem.getString();
                    String aa = new String(temp.getBytes("ISO-8859-1"),"UTF-8");
                    text[i++] = aa;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        UserDao userDao = new UserDaoImp();
        userDao.insertShow(text,img_url);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
