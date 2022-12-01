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
import java.util.ArrayList;
import java.util.List;
import models.Account;
import models.Order;
import models.Payment;
import models.Product;
import models.Transaction;
import models.UserDTO;
import models.Wallet;

import utils.DBUtil;

/**
 *
 * @author htmlo
 */
public class AccountDAO {

    private static final String SEARCH = "SELECT userID, fullName, roleID "
            + "FROM tblUsers WHERE fullName like ?";
    private static final String DELETE = "UPDATE Account SET Status=False "
            + "WHERE Id=?";
    private static final String UPDATE = "UPDATE Account SET UserName=?,FullName=?,Password=?,Phone=?, Address=? "
            + "                         WHERE Id=?";
    private static final String CHECK_DUPLICATE = "SELECT UserName, roleID "
            + "FROM Account WHERE Id=?";
    private static final String List_ALL_ACCOUNT = "SELECT * "
            + "FROM Account join Role on [Account].RoleID = [Role].ID ORDER BY Account.userName DESC";
    private static final String CHECK_LOGIN = "SELECT Account.Id,UserName, FullName,Password, Status,Phone ,Address, RoleID \n"
            + "WHERE UserName=? AND Password=?";

    private static final String LOGIN = "SELECT Account.Id, FullName, Email,Phone, Address, RoleName "
            + "FROM Account join Role on [Account].RoleID = [Role].ID WHERE UserName = ? AND Password = ? AND Status= 1";
    private static final String CHECK_USERNAME = "SELECT UserName "
            + "FROM Account WHERE UserName = ?";
    private static final String INSERT = "INSERT INTO Account(UserName, FullName, Email,Password, Status, Phone, Address, RoleID) \n"
            + "VALUES(?,?,?,?,?,?,?,?)";
    private static final String TAKE_USERID = "SELECT TOP 1 Id FROM Account ORDER BY Id desc";
    private static final String CHANGE_PASSWORD = "UPDATE Account "
            + "SET password=? WHERE userName=?";
    private static final String UPDATE_ACCOUNT = "UPDATE Account \n" +
                                            "SET fullName=?,email=?, phone=?,address=? \n" +
                                            "WHERE email=?";
    private static final String CHECK_PASSWORD = "SELECT Password "
            + "FROM Account WHERE UserName = ? AND Password = ?";
    private static final String CHECK_EMAIL = "SELECT Account.Id, UserName,FullName, Email, Password, Phone, Address, RoleName\n"
            + "FROM Account join Role on [Account].RoleID = [Role].ID WHERE Email = ?";
    private static final String CHECK_WALLET = "SELECT UserID FROM Wallet Where UserID = ?";
    private static final String CREATE_WALLET = "INSERT INTO  Wallet(Amount, UserID) VALUES (0,?)";
    private static final String ADD_MONEY = "UPDATE Wallet SET Amount = Amount + ? WHERE UserID = ?";
    private static final String TAKE_AMOUNT = "SELECT ID, Amount FROM Wallet WHERE UserID = ?";
    private static final String POSTED_FEED = "SELECT Product.Id,ProductName, ProductPrice, ImageLink\n"
            + "FROM Product left join [Image]\n"
            + "ON Product.Id = [Image].ProductID\n"
            + "WHERE UserID = ?";
    private static final String HISTORT_ORDER = "SELECT Product.Id,ProductName, ProductPrice, ImageLink\n"
            + "FROM [Order] left join Product ON Product.Id = [Order].ProductID \n"
            + "left join [Image] ON Product.Id = [Image].ProductID\n"
            + "WHERE [Order].UserID = ?";

    private static final String CREATE_PAYMENT = "INSERT INTO Payment(PaymentTime, Amount, PaymentType, OrderID) VALUES(?,?,?,?)";
    private static final String CREATE_TRANSACTION = "INSERT INTO [dbo].[Transaction](Description, Amount, WalletID, PaymentID) VALUES(?,?,?,?)";
    private static final String TAKE_PAYMENT = "SELECT Top 1 ID,PaymentTime, Amount, PaymentType, OrderID FROM Payment ORDER BY Id desc";
    private static final String TAKE_TRANSACTION = "SELECT [dbo].[Transaction].Id, description, [dbo].[Transaction].Amount, WalletID, PaymentID FROM [dbo].[Transaction] \n"
            + "JOIN Wallet ON [dbo].[Transaction].WalletID = Wallet.Id\n"
            + "WHERE UserID = ? ORDER BY [dbo].[Transaction].Id DESC";
    private static final String TAKE_ORDERID = "SELECT  Top 1 Id FROM [dbo].[Order]  ORDER BY Id desc";
    private static final String UPDATE_MONEY = "UPDATE Wallet SET Amount = Amount - ? WHERE UserID = ?";

    //SETTING_PROFILE_CONTROLLER    
    private static final String CHECK_USER_BY_EMAIL = "SELECT Account.Id, UserName, FullName, Password, Status, Phone, Address, RoleName "
            + "FROM Account join Role on [Account].RoleID = [Role].ID WHERE Email = ?";
    private static final String SETTING_PROFILE = "UPDATE Account \n"
            + "SET FullName=?,Email=?, Status = ?, Phone=?,Address=?, RoleID=?\n"
            + "WHERE userName=?";
    private static final String noOfOrder = "SELECT COUNT(Product.Id) AS NumberOfProducts FROM Product WHERE UserID = ?";
    private static final String latestPostedFeed = "SELECT TOP(1) Product.Id,ProductName, ProductPrice\n"
            + "FROM Product\n"
            + "WHERE UserID = ?\n"
            + "ORDER BY Id DESC";
    private static final String successOrderSold = "SELECT COUNT([Order].ProductID) as successOrderSold\n"
            + "FROM [Order] left join Account ON [Order].UserID = Account.Id\n"
            + "left join Product ON [Order].ProductID = Product.Id\n"
            + "WHERE isAdmin = 1 and isBuyer = 1 and [Order].UserID = ?;";
    private static final String getAccountIDFromProduct = "SELECT UserID\n"
            + "FROM Product\n"
            + "WHERE Id = ?";

    public int getAccountFromProduct(String ProductID) {
        int num = 0;
        DBUtil db = new DBUtil();
        try {
            Connection con = db.getConnection();
            PreparedStatement stm = con.prepareStatement(getAccountIDFromProduct);
            stm.setString(1, ProductID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                num = rs.getInt(1);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }

//    public static void main(String[] args) {
//        AccountDAO d = new AccountDAO();
//        int userID = d.getAccountFromProduct(1);
//        int numberofOrder = d.noOfOrder(userID);
//        int successOrderSold = d.successOrderSold(userID);
//        Product product = d.latestPostedFeed(userID);
//        System.out.println(numberofOrder);
//        System.out.println(successOrderSold);
//        System.out.println(product);
//    }

    public int noOfOrder(int UserID) {
        int num = 0;
        DBUtil db = new DBUtil();
        try {
            Connection con = db.getConnection();
            PreparedStatement stm = con.prepareStatement(noOfOrder);
            stm.setInt(1, UserID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                num = rs.getInt(1);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }

    public int successOrderSold(int UserID) {
        int num = 0;
        DBUtil db = new DBUtil();
        try {
            Connection con = db.getConnection();
            PreparedStatement stm = con.prepareStatement(successOrderSold);
            stm.setInt(1, UserID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                num = rs.getInt(1);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }

    public Product latestPostedFeed(int UserID) {
        DBUtil db = new DBUtil();
        Product product = new Product();
        try {
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement(latestPostedFeed);
            ps.setInt(1, UserID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), "");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> postedFeed(int UserID) {
        List<Product> list = null;
        DBUtil db = new DBUtil();
        try {
            list = new ArrayList<>();
            Connection con = db.getConnection();
            PreparedStatement pst = con.prepareStatement(POSTED_FEED);
            pst.setInt(1, UserID);
            ResultSet rs = pst.executeQuery();
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

    public List<Product> historyOrder(int UserID) {
        List<Product> list = null;
        DBUtil db = new DBUtil();
        try {
            list = new ArrayList<>();
            Connection con = db.getConnection();
            PreparedStatement pst = con.prepareStatement(HISTORT_ORDER);
            pst.setInt(1, UserID);
            ResultSet rs = pst.executeQuery();
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

    public List<UserDTO> listAll() {
        List<UserDTO> list = null;
        DBUtil db = new DBUtil();
        try {
            list = new ArrayList<>();
            Connection con = db.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(List_ALL_ACCOUNT);
            while (rs.next()) {
                String accountId = rs.getString(1);
                String username = rs.getString(2);
                String fullname = rs.getString(3);
                String email = rs.getString(4);
                String pass = rs.getString(5);
                boolean status = rs.getBoolean(6);
                String phone = rs.getString(7);
                String address = rs.getString(8);
                String role = rs.getString("RoleName");
                UserDTO act = new UserDTO(accountId, username,
                        fullname, email, pass, status, phone, address, role);
                list.add(act);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean deleteAccount(String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, userID);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean updateAccount(Account act) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, act.getUserName());
                ptm.setString(2, act.getFullName());
                ptm.setString(3, act.getPassword());
                ptm.setString(4, act.getPhone());
                ptm.setString(5, act.getAddress());

                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean checkDuplicate(String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                ptm = conn.prepareCall(CHECK_DUPLICATE);
                ptm.setString(1, userID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public Account checkLogin(String userName, String password) throws SQLException {
        Account act = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                ptm = conn.prepareCall(CHECK_LOGIN);
                ptm.setString(1, userName);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    int accountId = rs.getInt("Id");
                    String fullName = rs.getString("FullName");
                    boolean status = rs.getBoolean("Status");
                    String phone = rs.getString("Phone");
                    String address = rs.getString("Address");
                    int role = rs.getInt("RoleID");
                    act = new Account(accountId, userName, fullName, password, status, phone, address, role);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return act;
    }

    public UserDTO checkLoginV2(String username, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement(LOGIN);
                pst.setString(1, username);
                pst.setString(2, password);
                rs = pst.executeQuery();
                if (rs.next()) {
                    String id = rs.getString("Id");
                    String fullName = rs.getString("FullName");
                    String email = rs.getString("Email");
                    String phone = rs.getString("Phone");
                    String address = rs.getString("Address");
                    String roleName = rs.getString("RoleName");
                    user = new UserDTO(id, username, fullName, email, password, true, phone, address, roleName);
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
        return user;
    }

    public boolean insert(UserDTO user) throws ClassNotFoundException, SQLException, Exception {
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                psm = conn.prepareStatement(INSERT);
                psm.setString(1, user.getUserName());
                psm.setString(2, user.getFullName());
                psm.setString(3, user.getEmail());
                psm.setString(4, user.getPassword());
                psm.setBoolean(5, true);
                psm.setString(6, user.getPhone());
                psm.setString(7, user.getAddress());
                psm.setInt(8, 2);
                check = psm.executeUpdate() > 0 ? true : false;
            }
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

    public String takeUserID() throws SQLException {
        String userID = "";
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement(TAKE_USERID);
                rs = pst.executeQuery();
                if (rs.next()) {
                    userID = rs.getString("Id");
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
        return userID;
    }

    public boolean checkUserName(String userName) throws SQLException {
//        UserDTO user = null;
        boolean check = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement(CHECK_USERNAME);
                pst.setString(1, userName);
                rs = pst.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return check;
    }

    public boolean update(UserDTO user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                psm = conn.prepareStatement(UPDATE_ACCOUNT);
                psm.setString(1, user.getFullName());
                psm.setString(2, user.getEmail());
                psm.setString(3, user.getPhone());
                psm.setString(4, user.getAddress());
                psm.setString(5, user.getEmail());
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

    public boolean changePassword(String password, String userName) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                psm = conn.prepareStatement(CHANGE_PASSWORD);
                psm.setString(1, password);
                psm.setString(2, userName);
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

    public boolean checkPassword(String userName, String password) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement(CHECK_PASSWORD);
                pst.setString(1, userName);
                pst.setString(2, password);
                rs = pst.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return check;
    }

    public UserDTO checkEmail(String email) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement(CHECK_EMAIL);
                pst.setString(1, email);
                rs = pst.executeQuery();
                if (rs.next()) {
                    String id = rs.getString("Id");
                    String username = rs.getString("UserName");
                    String fullName = rs.getString("FullName");
                    String password = rs.getString("Password");
                    String phone = rs.getString("Phone");
                    String address = rs.getString("Address");
                    String roleName = rs.getString("RoleName");
                    user = new UserDTO(id, username, fullName, email, password, true, phone, address, roleName);
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
        return user;
    }

    public boolean CheckWallet(String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement(CHECK_WALLET);
                pst.setString(1, userID);
                rs = pst.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return check;
    }

    public boolean CreateWallet(String UserID) throws Exception {
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                psm = conn.prepareStatement(CREATE_WALLET);
                psm.setString(1, UserID);
                check = psm.executeUpdate() > 0 ? true : false;
            }
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

    public boolean AddMoney(Float amount, String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                psm = conn.prepareStatement(ADD_MONEY);
                psm.setFloat(1, amount);
                psm.setString(2, userID);
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

    public Wallet TakeAmount(String userID) throws SQLException {
        Wallet wallet = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement(TAKE_AMOUNT);
                pst.setString(1, userID);
                rs = pst.executeQuery();
                if (rs.next()) {
                    int ID = rs.getInt("ID");
                    float amount = rs.getFloat("Amount");
                    wallet = new Wallet(ID, amount, userID);
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

        return wallet;
    }

    public boolean createPayment(Date paymentDate, float amount, String paymentType, int orderID) throws Exception {
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                psm = conn.prepareStatement(CREATE_PAYMENT);
                psm.setDate(1, paymentDate);
                psm.setFloat(2, amount);
                psm.setString(3, paymentType);
                psm.setInt(4, orderID);
                check = psm.executeUpdate() > 0 ? true : false;
            }
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

    public boolean createTransaction(String description, float amount, int walletID, int paymentID) throws Exception {
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                psm = conn.prepareStatement(CREATE_TRANSACTION);
                psm.setString(1, description);
                psm.setFloat(2, amount);
                psm.setInt(3, walletID);
                psm.setInt(4, paymentID);
                check = psm.executeUpdate() > 0 ? true : false;
            }
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

    public Payment takePayment() throws SQLException {
        Payment payment = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement(TAKE_PAYMENT);
                rs = pst.executeQuery();
                if (rs.next()) {
                    int ID = rs.getInt("Id");
                    Date paymentTime = rs.getDate("PaymentTime");
                    float amount = rs.getFloat("Amount");
                    String paymentType = rs.getString("PaymentType");
                    int orderID = rs.getInt("orderID");
                    payment = new Payment(ID, paymentTime, amount, paymentType, orderID);
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
        return payment;
    }

    public List<Transaction> takeTransaction(String userID) throws SQLException {
        List<Transaction> list = null;
        Transaction transaction = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            list = new ArrayList<>();
            if (conn != null) {
                pst = conn.prepareStatement(TAKE_TRANSACTION);
                pst.setString(1, userID);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int ID = rs.getInt("Id");
                    String description = rs.getString("description");
                    float amount = rs.getFloat("Amount");
                    int walletID = rs.getInt("WalletID");
                    int paymentID = rs.getInt("PaymentID");
                    transaction = new Transaction(ID, description, amount, walletID, paymentID);
                    list.add(transaction);
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

        return list;
    }

    public int takeOrderID() throws SQLException {
        int orderID = 0;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement(TAKE_ORDERID);
                rs = pst.executeQuery();
                if (rs.next()) {
                    orderID = rs.getInt("Id");
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
        return orderID;
    }

    public boolean UpdateMoney(float amount, String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                psm = conn.prepareStatement(UPDATE_MONEY);
                psm.setFloat(1, amount);
                psm.setString(2, userID);
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

    //use in ADMIN//use in ADMIN
    public UserDTO getUserByEmail(String email) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement(CHECK_USER_BY_EMAIL);
                pst.setString(1, email);
                rs = pst.executeQuery();
                if (rs.next()) {
                    String id = rs.getString("Id");
                    String username = rs.getString("UserName");
                    String fullName = rs.getString("FullName");
                    String password = rs.getString("Password");
                    String phone = rs.getString("Phone");
                    String address = rs.getString("Address");
                    String roleName = rs.getString("RoleName");
                    user = new UserDTO(id, username, fullName, email, password, true, phone, address, roleName);
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
        return user;
    }
//use in ADMIN

    public boolean settingProfile(String userName, String fullName, String email, String phone, String address, String roleID, boolean status) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                psm = conn.prepareStatement(SETTING_PROFILE);
                psm.setString(1, fullName);
                psm.setString(2, email);
                psm.setBoolean(3, status);
                psm.setString(4, phone);
                psm.setString(5, address);
                psm.setInt(6, Integer.parseInt(roleID));
                psm.setString(7, userName);
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

    //search in admin
    public List<UserDTO> findUserByFullName_Admin(String search) {
        List<UserDTO> list = null;
        DBUtil db = new DBUtil();
        if (search == null) {
            search = "";
        }
        try {
            list = new ArrayList<>();
            Connection con = db.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT Account.Id, UserName, FullName, Email, Password, Status, Phone, Address, RoleName\n"
                    + "FROM Account left join Role ON [Account].RoleID = [Role].ID WHERE UserName LIKE ? ORDER BY Account.userName DESC");
            pstm.setString(1, "%" + search + "%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                String accountId = rs.getString(1);
                String username = rs.getString(2);
                String fullname = rs.getString(3);
                String email = rs.getString(4);
                String pass = rs.getString(5);
                boolean status = rs.getBoolean(6);
                String phone = rs.getString(7);
                String address = rs.getString(8);
                String role = rs.getString("RoleName");
                UserDTO act = new UserDTO(accountId, username,
                        fullname, email, pass, status, phone, address, role);
                list.add(act);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public int takeWallet(String userID) throws SQLException {
        int id = 0;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement("SELECT Id FROM [dbo].[Wallet] WHERE UserID = ?");
                pst.setString(1, userID);
                rs = pst.executeQuery();
                if (rs.next()) {
                    id = rs.getInt("Id");
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
        return id;
    }

}
