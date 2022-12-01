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
public class Transaction {
    private int transactionID;
    private String description;
    private float amount;
    private int walletID;
    private int paymentID;

    public Transaction() {
    }

    public Transaction(int transactionID, String description, float amount, int walletID, int paymentID) {
        this.transactionID = transactionID;
        this.description = description;
        this.amount = amount;
        this.walletID = walletID;
        this.paymentID = paymentID;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getWalletID() {
        return walletID;
    }

    public void setWalletID(int walletID) {
        this.walletID = walletID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    
}
