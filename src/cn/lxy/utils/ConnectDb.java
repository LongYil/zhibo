package cn.lxy.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDb {  
    private static String driveClassName = "com.mysql.jdbc.Driver";  
    private static String url = "jdbc:mysql://"+ServerInfo.SERVER_IP+":3306/CollegeLive?useUnicode=true&characterEncoding=utf8";   
      
    private static String user = "root";  
    private static String password = "1234";  
      
    public static Connection Connect(){  
        Connection conn = null;   
        //load driver  
        try {  
            Class.forName(driveClassName);  
        } catch (ClassNotFoundException  e) {  
            System.out.println("load driver failed!");  
            e.printStackTrace();  
        }  
          
        //connect db  
        try {  
            conn = DriverManager.getConnection(url, user, password);  
        } catch (SQLException e) {  
            System.out.println("connect failed!");  
            e.printStackTrace();  
        }         
          
        return conn;  
    }  
} 
