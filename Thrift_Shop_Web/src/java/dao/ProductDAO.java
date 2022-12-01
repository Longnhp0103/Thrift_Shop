/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import utils.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Product;

public class ProductDAO {

    public List<Product> listAll(int userID) {
        List<Product> list = null;
        DBUtil db = new DBUtil();
        try {
            list = new ArrayList<>();
            String sql = "SELECT Product.Id, ProductName, ProductPrice, ImageLink, CategoryID\n"
                    + "FROM Product left join [Image] \n"
                    + "ON Product.Id = [Image].ProductID\n"
                    + "EXCEPT\n"
                    + "SELECT Product.Id, ProductName, ProductPrice, ImageLink, CategoryID\n"
                    + "FROM Product left join [Image] \n"
                    + "ON Product.Id = [Image].ProductID\n"
                    + "WHERE UserID = ?";
            Connection con = db.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, userID);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int productID = rs.getInt(1);
                String productName = rs.getString(2);
                int productPrice = rs.getInt(3);
                String imageLink = rs.getString(4);
                int categoryID = rs.getInt(5);
                Product pro = new Product(productID, productName, productPrice,
                        imageLink, categoryID);
                list.add(pro);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> listNew() {
        List<Product> list = null;
        DBUtil db = new DBUtil();
        try {
            list = new ArrayList<>();
            Connection con = db.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT TOP(6) Product.Id,"
                    + "ProductName,ProductPrice, ImageLink,CategoryID\n"
                    + "FROM Product left join [Image]\n"
                    + "ON Product.Id = [Image].ProductID\n"
                    + "WHERE status = 1"
                    + "ORDER BY Product.Id DESC");
            while (rs.next()) {
                int productID = rs.getInt(1);
                String productName = rs.getString(2);
                int productPrice = rs.getInt(3);
                String imageLink = rs.getString(4);
                Product pro = new Product(productID, productName,
                        productPrice, imageLink);
                list.add(pro);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> getProductByCID(String categoryID) {
        List<Product> list = null;
        DBUtil db = new DBUtil();
        try {
            list = new ArrayList<>();
            Connection con = db.getConnection();
            String sql = "SELECT Product.Id,ProductName,\n"
                    + "ProductPrice, ImageLink, CategoryID\n"
                    + "FROM Product left join [Image]\n"
                    + "ON Product.Id = [Image].ProductID\n"
                    + "WHERE CategoryID = ? AND status = 1\n"
                    + "ORDER BY Product.ProductName DESC";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, categoryID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int productID = rs.getInt(1);
                String productName = rs.getString(2);
                int productPrice = rs.getInt(3);
                String imageLink = rs.getString(4);
                Product pro = new Product(productID, productName,
                        productPrice, imageLink);
                list.add(pro);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean productAfterCheckout(int productID) {
        DBUtil db = new DBUtil();
        String query = "UPDATE Product\n"
                + "SET status=0\n"
                + "WHERE Id = ?";
        boolean check = false;
        try {
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, productID);
            check = ps.executeUpdate() > 0 ? true : false;
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public Product getProductbyID(String pid) {
        DBUtil db = new DBUtil();
        String query = "SELECT ProductID,ProductName,ProductPrice, \n"
                + "ProductDesc,Rating, ImageLink,CategoryID,FullName, Email, "
                + "[Address], Phone, UserID\n"
                + "FROM dbo.Product left join [Image]\n"
                + "ON Product.Id = [Image].ProductID\n"
                + "left join [Account]\n"
                + "ON Product.UserID = [Account].Id\n"
                + "WHERE ProductID= ?";
        try {
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, pid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getString(4), rs.getFloat(5), rs.getString(6),
                        rs.getInt(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11), rs.getInt(12));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getRelatedProduct(String categoryID, int productID) {
        List<Product> list = null;
        DBUtil db = new DBUtil();
        try {
            list = new ArrayList<>();
            Connection con = db.getConnection();
            String sql = "SELECT TOP(7) Product.Id,ProductName,\n"
                    + "ProductPrice, ImageLink, CategoryID\n"
                    + "FROM Product left join [Image] \n"
                    + "ON Product.Id = [Image].ProductID\n"
                    + "WHERE CategoryID = ? AND status = 1\n"
                    + "EXCEPT\n"
                    + "SELECT Product.Id,ProductName,\n"
                    + "ProductPrice, ImageLink, CategoryID\n"
                    + "FROM Product left join [Image] \n"
                    + "ON Product.Id = [Image].ProductID\n"
                    + "WHERE Product.Id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, categoryID);
            ps.setInt(2, productID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                productID = rs.getInt(1);
                String productName = rs.getString(2);
                int productPrice = rs.getInt(3);
                String imageLink = rs.getString(4);
                Product pro = new Product(productID, productName,
                        productPrice, imageLink);
                list.add(pro);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> listHome() {
        List<Product> list = null;
        DBUtil db = new DBUtil();
        try {
            list = new ArrayList<>();
            Connection con = db.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT Product.Id, ProductPrice,"
                    + "ProductName,ImageLink\n"
                    + "FROM Product left join [Image]\n"
                    + "ON Product.Id = [Image].ProductID\n"
                    + "WHERE status = 1"
                    + "ORDER BY ProductName ASC\n");
            while (rs.next()) {
                int productID = rs.getInt(1);
                int productPrice = rs.getInt(2);
                String productName = rs.getString(3);
                String imageLink = rs.getString(4);
                Product pro = new Product(productID, productName, productPrice,
                        imageLink);
                list.add(pro);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> paging(int index) {
        List<Product> list = null;
        DBUtil db = new DBUtil();
        String query = "SELECT Product.Id, ProductPrice,ProductName,ImageLink\n"
                + "FROM Product left join [Image]\n"
                + "ON Product.Id = [Image].ProductID\n"
                + "ORDER BY ProductName ASC\n"
                + "OFFSET ? ROWS FETCH NEXT 16 ROWs ONLY";
        try {
            list = new ArrayList<>();
            Connection con = db.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, (index - 1) * 16);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int productID = rs.getInt(1);
                int productPrice = rs.getInt(2);
                String productName = rs.getString(3);
                String imageLink = rs.getString(4);
                Product pro = new Product(productID, productName, productPrice,
                        imageLink);
                list.add(pro);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> findProductByName(String search) {
        List<Product> list = null;
        DBUtil db = new DBUtil();
        if (search == null) {
            search = "";
        }
        try {
            list = new ArrayList<>();
            Connection con = db.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT Product.Id, "
                    + "ProductPrice,ProductName,ImageLink, CategoryID\n"
                    + "FROM dbo.Product left join [Image]\n"
                    + "ON Product.Id = [Image].ProductID\n"
                    + "WHERE ProductName LIKE ? ");
            pstm.setString(1, "%" + search + "%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int productID = rs.getInt(1);
                int productPrice = rs.getInt(2);
                String productName = rs.getString(3);
                String imageLink = rs.getString(4);
                Product pro = new Product(productID, productName, productPrice,
                        imageLink);
                list.add(pro);
            }
            con.close();
        } catch (Exception e) {
        }
        return list;
    }
    
    public boolean insertImagine(String img, int productID) throws SQLException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement("INSERT INTO [dbo].[Image] VALUES(?,?)");
                pst.setString(1, img);
                pst.setInt(2, productID);
                check = pst.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
    public int TakeProductID() throws SQLException {
        int proID = 0;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement("SELECT TOP 1 Id FROM Product ORDER BY Id DESC");
                rs = pst.executeQuery();
                if (rs.next()) {
                    proID = rs.getInt("Id");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return proID;
    }
    
    

    public static void main(String[] args) {
        ProductDAO d = new ProductDAO();
        List<Product> list = new ArrayList<>();
        list = d.listAllProduct();
        for (Product product : list) {
            System.out.println(product);
        }

    }

//    public boolean insert(String ProductName, int ProductPrice, int ProductQuantity, String ProductDesc, int CategoryID, int UserID, boolean status) throws SQLException {
//        boolean check = false;
//        Connection conn = null;
//        PreparedStatement pst = null;
//        ResultSet rs = null;
//        DBUtil db = new DBUtil();
//        try {
//            conn = db.getConnection();
//            if (conn != null) {
//                pst = conn.prepareStatement("INSERT INTO [Product] (ProductName,"
//                        + "ProductPrice,ProductQuantity, ProductDesc,CategoryID,"
//                        + " UserID, [Status])\n"
//                        + "VALUES (?,?,?,?,?,?,?)");
//                pst.setString(1, ProductName);
//                pst.setInt(2, ProductPrice);
//                pst.setInt(3, ProductQuantity);
//                pst.setString(4, ProductDesc);
//                pst.setInt(5, CategoryID);
//                pst.setInt(6, UserID);
//                pst.setBoolean(7, status);
//                check = pst.executeUpdate() > 0 ? true : false;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (pst != null) {
//                pst.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
//        return check;
//    }
    public boolean insert1(Product pro) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement("INSERT INTO [Product] (ProductName,"
                        + "ProductPrice,ProductQuantity, ProductDesc,CategoryID,"
                        + " UserID, [Status])\n"
                        + "VALUES (?,?,?,?,?,?,?)");
                pst.setString(1, pro.getProductName());
                pst.setInt(2, pro.getProductPrice());
                pst.setInt(3, pro.getProductQuantity());
                pst.setString(4, pro.getProductDesc());
                pst.setInt(5, pro.getCategoryID());
                pst.setInt(6, pro.getUserID());
                pst.setBoolean(7, pro.isStatus());
                check = pst.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public int getLastProductID() {
        int num = 0;
        DBUtil db = new DBUtil();
        try {
            Connection con = db.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT TOP(1) Id\n"
                    + "FROM Product\n"
                    + "ORDER BY Id DESC");
            while (rs.next()) {
                num = rs.getInt(1);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }

    public int minPrice() {

        int price = 0;

        DBUtil db = new DBUtil();

        try {

            Connection con = db.getConnection();

            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery("SELECT MIN(ProductPrice) FROM Product");

            while (rs.next()) {

                price = rs.getInt(1);

            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return price;

    }

    public int maxPrice() {
        int price = 0;
        DBUtil db = new DBUtil();
        try {
            Connection con = db.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT MAX(ProductPrice) FROM Product");
            while (rs.next()) {
                price = rs.getInt(1);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return price;
    }
    //use in ADMIN
    public boolean settingProduct(int productID, int categoriesID, String productName, float price, boolean status, String productDecs) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                psm = conn.prepareStatement("UPDATE Product \n"
            + "SET ProductName=?, ProductPrice = ?, ProductDesc=?,CategoryID=?, status=?\n"
            + "WHERE Id=?");
                psm.setString(1, productName);
                psm.setFloat(2, price);
                psm.setString(3, productDecs);
                psm.setInt(4, categoriesID);
                psm.setBoolean(5, status);
                psm.setInt(6, productID);
                check = psm.executeUpdate() > 0 ? true : false;
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
    
        public boolean updateProductAfterShipped(int productID, boolean status) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                psm = conn.prepareStatement("UPDATE [Product] \n"
            + "SET status=? \n"
            + "WHERE Id=?");               
                psm.setBoolean(1, status);
                psm.setInt(2, productID);
                check = psm.executeUpdate() > 0 ? true : false;
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

    
    //use in ADMIN
    public List<Product> listAllProduct() {
        List<Product> list = null;
        DBUtil db = new DBUtil();
        try {
            list = new ArrayList<>();
            Connection con = db.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT Product.Id,ProductName,\n"
                    + "ImageLink, Product.status, UserID, CategoryName,FullName \n"
                    + "FROM Product left join [Image] \n"
                    + "ON Product.Id = [Image].ProductID \n"
                    + "left join [Category] \n"
                    + "ON Product.CategoryID = [Category].Id\n"
                    + "left join [Account] \n"
                    + "ON Product.UserID = [Account].Id\n"
                    + "ORDER BY Product.ProductName DESC");
            while (rs.next()) {
                int productID = rs.getInt(1);
                String productName = rs.getString(2);               
                String imageLink = rs.getString(3);
                boolean status = rs.getBoolean(4);
                int userID = rs.getInt(5);
                String categoryName = rs.getString(6);
                String fullName = rs.getString(7);
                Product pro = new Product(productID, productName, imageLink,
                        status, userID, categoryName, fullName);
                list.add(pro);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    //use in admin
    public List<Product> findProductByName_Admin(String search) {
        List<Product> list = null;
        DBUtil db = new DBUtil();
        if (search == null) {
            search = "";
        }
        try {
            list = new ArrayList<>();
            Connection con = db.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT Product.Id,ProductName,\n"
                    + "ImageLink, Product.status, UserID, CategoryName,FullName \n"
                    + "FROM Product left join [Image] \n"
                    + "ON Product.Id = [Image].ProductID \n"
                    + "left join [Category] \n"
                    + "ON Product.CategoryID = [Category].Id\n"
                    + "left join [Account] \n"
                    + "ON Product.UserID = [Account].Id\n"
                    + "WHERE ProductName LIKE ?");
            pstm.setString(1, "%" + search + "%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int productID = rs.getInt(1);
                String productName = rs.getString(2);               
                String imageLink = rs.getString(3);
                boolean status = rs.getBoolean(4);
                int userID = rs.getInt(5);
                String categoryName = rs.getString(6);
                String fullName = rs.getString(7);
                Product pro = new Product(productID, productName, imageLink,
                        status, userID, categoryName, fullName);
                list.add(pro);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    

//    public List<Product> filter(String genreID, String consolesID, int minPrice, int maxPrice, String rating) {
//
//        List<Product> list = null;
//
//        DBUtil db = new DBUtil();
//
//        String genreCondition = " ";
//
//        String consolesCondition = " ";
//
//        String ratingCondition = " ";
//
//        if (genreID != null) {
//
//            genreCondition = " genreID = " + genreID + " and ";
//
//        }
//
//        if (consolesID != null) {
//
//            consolesCondition = " consolesID = " + consolesID + " and ";
//
//        }
//
//        if (rating != null) {
//
//            ratingCondition = " rating = " + rating + " and ";
//
//        }
//
//        try {
//
//            list = new ArrayList<>();
//
//            Connection con = db.getConnection();
//
//            PreparedStatement pstm = con.prepareStatement("SELECT ProductID, ProductPrice,ProductName,LinkIMG1\n"
//                    + "FROM dbo.Product \n"
//                    + "Where" + genreCondition + consolesCondition + ratingCondition + "ProductPrice >= ? AND ProductPrice <= ?");
//
//            pstm.setInt(1, minPrice);
//
//            pstm.setInt(2, maxPrice);
//
//            ResultSet rs = pstm.executeQuery();
//
//            while (rs.next()) {
//
//                int productID = rs.getInt(1);
//
//                int price = rs.getInt(2);
//
//                String productName = rs.getString(3);
//
//                String linkImg1 = rs.getString(4);
//
//                Product pro = new Product(productID, price, productName, linkImg1);
//
//                list.add(pro);
//
//            }
//
//            con.close();
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//
//        }
//
//        return list;
//
//    }

}
