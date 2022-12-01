/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author buile
 */
public class Product {

    private int productID;
    private String productName;
    private int productPrice;
    private int productQuantity;
    private String productDesc;
    private float rating;
    private String imageLink;
    private int categoryID;
    private String categoryName;//
    private String fullName;
    private String phone;
    private String email;
    private String address;
    private boolean status;
    private int userID;
    Category category = new Category();
    Account user = new Account();

    public Product() {
    }

    public Product(int productID, String productName, int productPrice, int productQuantity, String productDesc, float rating, Category category, Account user) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productDesc = productDesc;
        this.rating = rating;
        this.category = category;
        this.user = user;
    }

    public Product(int productID, String productName, int productPrice, String productDesc, float rating, String imageLink, int categoryID, String fullName, String phone, String email, String address, int userID) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDesc = productDesc;
        this.rating = rating;
        this.imageLink = imageLink;
        this.categoryID = categoryID;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.userID = userID;
    }
    
    

    public Product(int productID, String productName, int productPrice, String imageLink) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.imageLink = imageLink;
    }

    public Product(int productID, String productName, int productPrice, String productDesc, float rating, String imageLink, int categoryID, String fullName, String email, String address, String phone) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDesc = productDesc;
        this.rating = rating;
        this.imageLink = imageLink;
        this.categoryID = categoryID;
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public Product(int productID, String productName, int productPrice, String imageLink, int categoryID) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.imageLink = imageLink;
        this.categoryID = categoryID;
    }
    
    
    public Product(String productName, int productPrice, int productQuantity, String productDesc, int categoryID, boolean status, int userID) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productDesc = productDesc;
        this.categoryID = categoryID;
        this.status = status;
        this.userID = userID;
    }
    
    //use for admin
    public Product(int productID, String productName, String imageLink, int categoryID, int userID, boolean status) {
        this.productID = productID;
        this.productName = productName;
        this.imageLink = imageLink;
        this.imageLink = imageLink;
        this.categoryID = categoryID;
        this.userID = userID;
        this.status = status;
    }

    public Product(int productID, String productName, int productPrice, int productQuantity, String productDesc, String imageLink, int categoryID, String categoryName, String fullName, boolean status, int userID) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productDesc = productDesc;
        this.imageLink = imageLink;
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.fullName = fullName;
        this.status = status;
        this.userID = userID;
    }
    
    
     //use for admin
    public Product(int productID, String productName, String imageLink, boolean status, int userID, String categoryName, String fullName) {
        this.productID = productID;
        this.productName = productName;
        this.imageLink = imageLink;
        this.categoryName = categoryName;
        this.fullName = fullName; 
        this.status = status;
        this.userID = userID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
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

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Account getUser() {
        return user;
    }

    public void setUser(Account user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", productPrice=" + productPrice + ", productQuantity=" + productQuantity + ", productDesc=" + productDesc + ", rating=" + rating + ", imageLink=" + imageLink + ", categoryID=" + categoryID + ", categoryName=" + categoryName + ", fullName=" + fullName + ", phone=" + phone + ", email=" + email + ", address=" + address + ", status=" + status + ", userID=" + userID + ", category=" + category + ", user=" + user + '}';
    }
    


}
