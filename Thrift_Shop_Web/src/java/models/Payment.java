/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 *
 * @author Le Nguyen Nhat Minh
 */
public class Payment {
    private int paymentID;
    private Date paymentTime;
    private float amount;
    private String paymentType;
    private int orderID;

    public Payment(int paymentID, Date paymentTime, float amount, String paymentType, int orderID) {
        this.paymentID = paymentID;
        this.paymentTime = paymentTime;
        this.amount = amount;
        this.paymentType = paymentType;
        this.orderID = orderID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    
    

}