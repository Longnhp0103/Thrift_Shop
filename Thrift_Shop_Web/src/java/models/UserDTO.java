/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Admiz
 */
public class UserDTO {
    private String ID;
    private String userName;
    private String fullName;
    private String email;
    private String password;
    private boolean status;
    private String phone;
    private String address;
    private String roleName;

    public UserDTO() {
    }

    public UserDTO(String ID, String userName, String fullName, String email, String password, boolean status, String phone, String address, String roleName) {
        this.ID = ID;
        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.status = status;
        this.phone = phone;
        this.address = address;
        this.roleName = roleName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    

    
    
}
