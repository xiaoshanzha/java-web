package com.zb.login.dao;

import com.zb.login.beans.User;

import java.util.List;

public interface UserDao {
    public User getUsernameAndPassword(String username,String password);
    public User getUserByUsername(String username);
    public void insertUser(String username,String password);

    public List<User> selectAllUsers();

}
