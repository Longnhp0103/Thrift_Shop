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
public class UserError {
    private String userNameError;
    private String fullNameError;
    private String roleIDError;
    private String passwordError;
    private String confirmError;
    private boolean statusError;

    public UserError() {
        this.userNameError = "";
        this.fullNameError = "";
        this.roleIDError = "";
        this.passwordError = "";
        this.confirmError = "";
        this.statusError = true;
    }

    public UserError(String userNameError, String fullNameError, String roleIDError, String passwordError, String confirmError, boolean statusError) {
        this.userNameError = userNameError;
        this.fullNameError = fullNameError;
        this.roleIDError = roleIDError;
        this.passwordError = passwordError;
        this.confirmError = confirmError;
        this.statusError = statusError;
    }

    public String getUserNameError() {
        return userNameError;
    }

    public void setUserNameError(String userNameError) {
        this.userNameError = userNameError;
    }

    public String getFullNameError() {
        return fullNameError;
    }

    public void setFullNameError(String fullNameError) {
        this.fullNameError = fullNameError;
    }

    public String getRoleIDError() {
        return roleIDError;
    }

    public void setRoleIDError(String roleIDError) {
        this.roleIDError = roleIDError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getConfirmError() {
        return confirmError;
    }

    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

    public boolean isStatusError() {
        return statusError;
    }

    public void setStatusError(boolean statusError) {
        this.statusError = statusError;
    }
    
    
}
