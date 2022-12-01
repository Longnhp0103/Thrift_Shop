/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author buile
 */
public class Image {
    private int imageID;
    private int productID;
    private String imageLink;
    Product product = new Product();

    public Image() {
    }

    public Image(int imageID, String imageLink, Product product) {
        this.imageID = imageID;
        this.imageLink = imageLink;
        this.product = product;
    }

    public Image(int productID, String imageLink) {
        this.productID = productID;
        this.imageLink = imageLink;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
    

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Image{" + "imageID=" + imageID + ", productID=" + productID + ", imageLink=" + imageLink + ", product=" + product + '}';
    }
    
    
}
