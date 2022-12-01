/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;
import javax.swing.text.DateFormatter;
import models.Account;
import models.Order;
import models.Product;
import utils.DBUtil;

/**
 *
 * @author Le Nguyen Nhat Minh
 */
public class OrderDAO {

    public boolean checkout(Date OrderDate, Date ShipDate, String ShipAddress, int TotalPrice, Account UserID, Product ProductID) {
        boolean check = false;
        DBUtil db = new DBUtil();
        String query = "INSERT INTO [Order](OrderDate,Shipdate,ShipAddress,TotalPrice,UserID,ProductID)\n"
                + "VALUES (?,?,?,?,?,?)";
        try {
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDate(1, OrderDate);
            ps.setDate(2, ShipDate);
            ps.setString(3, ShipAddress);
            ps.setInt(4, TotalPrice);
            ps.setInt(5, UserID.getAccountID());
            ps.setInt(6, ProductID.getProductID());
            check = ps.executeUpdate() > 0 ? true : false;
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean checkout1(Date OrderDate, Date ShipDate, String ShipAddress, int TotalPrice, int UserID, int ProductID) {
        boolean check = false;
        DBUtil db = new DBUtil();
        String query = "INSERT INTO [Order](OrderDate,Shipdate,ShipAddress,TotalPrice,UserID,ProductID)\n"
                + "VALUES (?,?,?,?,?,?)";
        try {
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDate(1, OrderDate);
            ps.setDate(2, ShipDate);
            ps.setString(3, ShipAddress);
            ps.setInt(4, TotalPrice);
            ps.setInt(5, UserID);
            ps.setInt(6, ProductID);
            check = ps.executeUpdate() > 0 ? true : false;
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public List<Order> listAllOrder() {
        List<Order> list = null;
        DBUtil db = new DBUtil();
        try {
            list = new ArrayList<>();
            Connection con = db.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT [dbo].[Order].[Id]\n"
                    + "      ,[OrderDate]\n"
                    + "      ,[ShipDate]\n"
                    + "      ,[ShipAddress]\n"
                    + "      ,[TotalPrice]\n"
                    + "      ,[UserName]\n"
                    + "      ,[Order].[ProductID]\n"
                    + "      ,[ProductName]\n"
                    + "      ,[isAdmin]\n"
                    + "      ,[isBuyer]\n"
                    + "  FROM [dbo].[Order] LEFT JOIN [Account] ON [UserID] = [Account].Id\n"
                    + "  LEFT JOIN [Product] ON [ProductID] = [Product].Id");
            while (rs.next()) {
                int orderID = rs.getInt(1);
                Date OrderDate = rs.getDate(2);
                Date ShipDate = rs.getDate(3);
                String shipAddress = rs.getString(4);
                float totalPrice = rs.getFloat(5);
                String fullName = rs.getString(6);
                int productID = rs.getInt(7);
                String ProductName = rs.getString(8);
                boolean isAdmin = rs.getBoolean(9);
                boolean isBuyer = rs.getBoolean(10);
                Order or = new Order(orderID, OrderDate, ShipDate, shipAddress, totalPrice, fullName, productID, ProductName, isAdmin, isBuyer);
                list.add(or);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //Test method
    public static void main(String[] args) throws ParseException, SQLException {
        OrderDAO od = new OrderDAO();
//        long millis = System.currentTimeMillis();
//        java.sql.Date sqlOrderDate = new java.sql.Date(millis);
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(sqlOrderDate);
//        cal.add(Calendar.DAY_OF_YEAR, 1);
//        cal.set(Calendar.HOUR_OF_DAY, 0);
//        cal.set(Calendar.MINUTE, 0);
//        cal.set(Calendar.SECOND, 0);
//        cal.set(Calendar.MILLISECOND, 0);
//        java.sql.Date sqlShipDate = new java.sql.Date(cal.getTimeInMillis());
//        String ShipAddress = "Thanh Pho Hue";
//        int TotalPrice = 152;
//        int UserID = 1;
//        int ProductID = 23;
//        boolean check = od.checkout1(sqlOrderDate, sqlShipDate, ShipAddress, TotalPrice, UserID, ProductID);
//        if (check) {
//            System.out.println(check);
//        }
        List<Order> orderList = new ArrayList<Order>();
        orderList = od.listAllOrder();
        for (Order order : orderList) {
            System.out.println(order);
        }
    }

    public List<Order> findOrderByProductName_Admin(String search) {
        List<Order> list = null;
        DBUtil db = new DBUtil();
        if (search == null) {
            search = "";
        }
        try {
            list = new ArrayList<>();
            Connection con = db.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT [dbo].[Order].[Id]\n"
                    + "      ,[OrderDate]\n"
                    + "      ,[ShipDate]\n"
                    + "      ,[ShipAddress]\n"
                    + "      ,[TotalPrice]\n"
                    + "      ,[UserName]\n"
                    + "      ,[Order].[ProductID]\n"
                    + "      ,[ProductName]\n"
                    + "      ,[isAdmin]\n"
                    + "      ,[isBuyer]\n"
                    + "  FROM [dbo].[Order] LEFT JOIN [Account] ON [UserID] = [Account].Id\n"
                    + "  LEFT JOIN [Product] ON [ProductID] = [Product].Id\n"
                    + "  WHERE ProductName LIKE ?");
            pstm.setString(1, "%" + search + "%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int orderID = rs.getInt(1);
                Date OrderDate = rs.getDate(2);
                Date ShipDate = rs.getDate(3);
                String shipAddress = rs.getString(4);
                float totalPrice = rs.getFloat(5);
                String fullName = rs.getString(6);
                int productID = rs.getInt(7);
                String ProductName = rs.getString(8);
                boolean isAdmin = rs.getBoolean(9);
                boolean isBuyer = rs.getBoolean(10);
                Order or = new Order(orderID, OrderDate, ShipDate, shipAddress, totalPrice, fullName, productID, ProductName, isAdmin, isBuyer);
                list.add(or);
            }
            con.close();
        } catch (Exception e) {
        }
        return list;
    }

    public boolean updateOrderStatus(int orderID, boolean isAdmin, boolean isBuyer, int productID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                psm = conn.prepareStatement("UPDATE [Order] \n"
                        + "SET isAdmin=?, isBuyer = ? \n"
                        + "WHERE Id=?");
                psm.setBoolean(1, isAdmin);
                psm.setBoolean(2, isBuyer);
                psm.setInt(3, orderID);
                if (isAdmin == true && isBuyer == true) {
                    ProductDAO prd = new ProductDAO();
                    boolean checkSettingProduct = prd.updateProductAfterShipped(productID, false);
                    if (checkSettingProduct) {
//                        psm.setBoolean(2, isAdmin);
//                        psm.setBoolean(3, isBuyer);
                        check = psm.executeUpdate() > 0 ? true : false;
                    }
                } else {
                    ProductDAO prd = new ProductDAO();
                    boolean checkSettingProduct = prd.updateProductAfterShipped(productID, true);
                    if (checkSettingProduct) {
//                        psm.setBoolean(2, isAdmin);
//                        psm.setBoolean(3, isBuyer);
                        check = psm.executeUpdate() > 0 ? true : false;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (psm != null) {
                psm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
}