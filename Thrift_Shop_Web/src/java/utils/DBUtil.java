/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */

public class DBUtil {
    private String PASSWORD = "12345";
    public Connection getConnection() throws Exception{
        String url = "jdbc:sqlserver://localhost;databaseName=SWPShop;user=sa;password="+PASSWORD;
        Connection con = null;
        //Loading a driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //Creating a connection
        con = DriverManager.getConnection(url);
        return con;
    }
//    public static void main(String[] args) {
//        try {
//            System.out.println(new DBUtil().getConnection());
//        } catch (Exception e) {
//        }
//    }
}
