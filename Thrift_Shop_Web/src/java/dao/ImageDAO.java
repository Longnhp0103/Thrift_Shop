/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Image;
import utils.DBUtil;

/**
 *
 * @author Le Nguyen Nhat Minh
 */
public class ImageDAO {

    public boolean insertImageForProduct(Image product) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement("INSERT INTO [Image](ImageLink, ProductID)\n"
                        + "VALUES (?,?)");
                pst.setString(1, product.getImageLink());
                pst.setInt(2, product.getProductID());
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
}
