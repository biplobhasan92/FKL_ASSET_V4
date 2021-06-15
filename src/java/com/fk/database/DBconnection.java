
package com.fk.database;

import java.sql.Connection;
import java.sql.DriverManager;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBconnection {

    public static Connection conn = null;
    
    public static Connection getConnection()
    {
        try
        {
            Properties props = new Properties();
            InputStream inputStream = DBconnection.class.getClassLoader().getResourceAsStream("jdbc.properties");
            props.load(inputStream);
            Class.forName(props.getProperty("jdbc.driverClassName"));
            conn = DriverManager.getConnection(props.getProperty("jdbc.url"),
                    props.getProperty("jdbc.username"),props.getProperty("jdbc.password"));
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return conn;
    }
    
    
    
    public static void main(String[] args){
        DBconnection bconnection = new DBconnection();
        System.out.println("BD COnncetion : "+bconnection.getConnection());
    }
}
