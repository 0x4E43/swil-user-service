package com.swil.userservice.user.dto;

public class UserDetailsDto {
    private int id;
    private String UUID;
    private String username;
    private String emailId;
    private String password;
    private Short role; //USER:3, MANAGER: 2, ADMIN: 1
    private String mobile;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUUID() {
        return UUID;
    }
    public void setUUID(String uUID) {
        UUID = uUID;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Short getRole() {
        return role;
    }
    public void setRole(Short role) {
        this.role = role;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    


}
