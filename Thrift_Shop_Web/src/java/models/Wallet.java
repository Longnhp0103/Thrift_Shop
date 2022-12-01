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
public class Wallet {
    private int walletID;
    private float amount;
    private String userID;

    public Wallet() {
    }

    public Wallet(int walletID, float amount, String userID) {
        this.walletID = walletID;
        this.amount = amount;
        this.userID = userID;
    }

    public int getWalletID() {
        return walletID;
    }

    public void setWalletID(int walletID) {
        this.walletID = walletID;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    

    
    
    
}
