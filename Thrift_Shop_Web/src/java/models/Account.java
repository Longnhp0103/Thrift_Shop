/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Lenovo
 */
public class Account {

    private int accountID;
    private String userName;
    private String fullName;
    private String password;
    private boolean status;
    private String phone;
    private String address;
    private int roleNum;
    Role role = new Role();

    public Account(int accountID, String userName, String fullName, String password, boolean status, String phone, String address, Role role) {
        this.accountID = accountID;
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
        this.status = status;
        this.phone = phone;
        this.address = address;
        this.role = role;
    }
    public Account(int accountID, String userName, String fullName, String password, boolean status, String phone, String address, int role) {
        this.accountID = accountID;
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
        this.status = status;
        this.phone = phone;
        this.address = address;
        this.roleNum=role;
    }

    public int getRoleNum() {
        return roleNum;
    }

    public void setRoleNum(int roleNum) {
        this.roleNum = roleNum;
    }
    //use for update
    public Account(String userName, String fullName, String password, String phone, String address) {
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }
    

    public Account() {
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" + "accountID=" + accountID + ", userName=" + userName + ", fullName=" + fullName + ", password=" + password + ", status=" + status + ", phone=" + phone + ", address=" + address + ", roleNum=" + roleNum + ", role=" + role + '}';
    }
    

}
