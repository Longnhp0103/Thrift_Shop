/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author Le Nguyen Nhat Minh
 */
public class Order {
    private int orderID;
    private Date orderDate;
    private Date shipDate;
    private String shipAddress;
    private float totalPrice;
    private int userID;
    private String fullName;
    private int productID;
    private String productName;
    
    private boolean isAdmin; 
    private boolean isBuyer;
    
    Account user = new Account();
    Product product = new Product();

    public Order(int orderID, Date orderDate, Date shipDate, String shipAddress, float totalPrice, int userID, String fullName, int productID, String productName, boolean isAdmin, boolean isBuyer) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.shipAddress = shipAddress;
        this.totalPrice = totalPrice;
        this.userID = userID;
        this.fullName = fullName;
        this.productID = productID;
        this.productName = productName;
        this.isAdmin = isAdmin;
        this.isBuyer = isBuyer;
    }

    public Order(int orderID, Date orderDate, Date shipDate, String shipAddress, float totalPrice, String fullName,int productID, String productName, boolean isAdmin, boolean isBuyer) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.shipAddress = shipAddress;
        this.totalPrice = totalPrice;
        this.fullName = fullName;
        this.productID = productID;
        this.productName = productName;
        this.isAdmin = isAdmin;
        this.isBuyer = isBuyer;
    }
    

    public Order(int orderID, Date orderDate, Date shipDate, String shipAddress, int totalPrice, Account user, Product product ) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.shipAddress = shipAddress;
        this.totalPrice = totalPrice;
        this.user = user;
        this.product = product;
    }

    public Order(int orderID, Date orderDate, Date shipDate, String shipAddress, float totalPrice, int userID, int productID) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.shipAddress = shipAddress;
        this.totalPrice = totalPrice;
        this.userID = userID;
        this.productID = productID;
    }

    //use in admin
    public Order(int orderID, java.sql.Date OrderDate, java.sql.Date ShipDate, String shipAddress, float totalPrice, String fullName, String ProductName) {
        this.orderID = orderID;
        this.orderDate = OrderDate;
        this.shipDate = ShipDate;
        this.shipAddress = shipAddress;
        this.totalPrice = totalPrice;
        this.fullName = fullName;
        this.productName = ProductName;
    }
    

    public Order() {
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Account getUser() {
        return user;
    }

    public void setUser(Account user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean isIsBuyer() {
        return isBuyer;
    }

    public void setIsBuyer(boolean isBuyer) {
        this.isBuyer = isBuyer;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", orderDate=" + orderDate + ", shipDate=" + shipDate + ", shipAddress=" + shipAddress + ", totalPrice=" + totalPrice + ", userID=" + userID + ", fullName=" + fullName + ", productID=" + productID + ", productName=" + productName + ", isAdmin=" + isAdmin + ", isBuyer=" + isBuyer + ", user=" + user + ", product=" + product + '}';
    }


    
}
