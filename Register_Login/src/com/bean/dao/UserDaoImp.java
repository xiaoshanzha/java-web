package com.bean.dao;

import com.bean.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoImp implements UserDao{
    @Override
    public void insertShow(String[] text, String[] img_url) {
        try {
            Connection conn = ConnectionUtils.getConn();
            String sql = "insert into shows (user,time,text,type,img_0,img_1,img_2,img_3,img_4,img_5,img_6,img_7,img_8) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,text[0]);
            ps.setString(2,text[2]);
            ps.setString(3,text[1]);
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
        }finally {
            try {
                ConnectionUtils.closeConn();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
