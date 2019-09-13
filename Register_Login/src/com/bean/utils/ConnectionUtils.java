package com.bean.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtils {
    private static String driver = null;
    private static String url = null ;
    private static String username = null ;
    private static String password = null ;
    private static Properties props = new Properties();

    //ThreadLocal :保证一个线程中只能有一个连接.
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    /*
     * 静态代码块读取db.properties
     * */
    static {
        //类加载器读取文件
        InputStream in = ConnectionUtils.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            props.load(in);
            driver = props.getProperty("jdbc.driver");
            url = props.getProperty("jdbc.url");
            username= props.getProperty("jdbc.username");
            password = props.getProperty("jdbc.password");

            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * 获取连接
     * */
    public static Connection getConn() throws SQLException {
        Connection conn = tl.get();
        if(conn == null){
            conn = DriverManager.getConnection(url,username,password);
            tl.set(conn);
        }
        return conn;
    }

    /*
     * 关闭连接
     * */
    public static void closeConn() throws SQLException {
        Connection conn = tl.get();
        if(conn!=null){
            conn.close();
        }
        tl.set(null);
    }
}
