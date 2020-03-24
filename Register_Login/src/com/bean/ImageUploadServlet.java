package com.bean;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet("/ImageUploadServlet")
public class ImageUploadServlet extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        //保存路径
        String savePath = getServletContext().getRealPath("\\imgs\\");

        String finalPath = "http://101.37.79.26:8080/show/imgs/";
        // 创建文件上传核心类
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(factory);
        //设置编码
        sfu.setHeaderEncoding("UTF-8");

        try {
            out.println("");
            List<FileItem> itemList = sfu.parseRequest(request);
            for(FileItem fileItem : itemList){
                String fieldName = fileItem.getFieldName();
                if(!fileItem.isFormField()){
                    String fileName = fileItem.getName();
                    File file = new File(savePath,fileName);
                    if(!fileName.isEmpty()){
                        String temp_url = finalPath+fileName;
                        fileItem.write(file);
                        out.println(temp_url);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
