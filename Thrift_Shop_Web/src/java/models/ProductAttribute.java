/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Le Nguyen Nhat Minh
 */
public class ProductAttribute {
    private String value;
    Attribute attribute = new Attribute();
    Product product = new Product();

    public ProductAttribute(String value, Attribute attribute, Product product) {
        this.value = value;
        this.attribute = attribute;
        this.product = product;
    }

    public ProductAttribute() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
}
