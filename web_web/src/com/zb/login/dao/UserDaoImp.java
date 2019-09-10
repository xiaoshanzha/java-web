package com.zb.login.dao;

import com.zb.login.beans.User;
import com.zb.login.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao {
    @Override
    public User getUsernameAndPassword(String username, String password) {
        User u = null;
        try {
            Connection conn = ConnectionUtils.getConn();
            String sql = "select id,username,password from users where username = ? and password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
            }
            return u;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectionUtils.closeConn();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        User u = null;
        try {
            Connection conn = ConnectionUtils.getConn();

            String sql = "select id,username,password from users where username = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
            }
            return u;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectionUtils.closeConn();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void insertUser(String username, String password) {
        try {
            Connection conn = ConnectionUtils.getConn();
            String sql = "insert into users (username,password) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);

            ps.executeQuery();
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

    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<User>();
        try {
            Connection conn = ConnectionUtils.getConn();
            String sql = "select id,username,password from users";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));

                users.add(user);
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                ConnectionUtils.closeConn();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

