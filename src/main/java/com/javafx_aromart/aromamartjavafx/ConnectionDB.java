package com.javafx_aromart.aromamartjavafx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    static String user="root";
    static String passward="mohammedmogeab";
    static String url="jdbc:mysql://localhost/test";
    static String driver ="com.mysql.jdbc.Driver";
    public static Connection getConnection(){
        Connection connection = null;

        try {
            Class.forName(driver);
            try {
                connection= DriverManager.getConnection(url,user,passward);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
         return connection;
    }
}
