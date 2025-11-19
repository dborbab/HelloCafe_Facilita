package com.example.facilita;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class User {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String photo;
    private String role;
    private String verification_code;
    private Date code_expires_at;
    private Boolean deleted;
    private int cafe_id;



    @SerializedName("confirm-password")
    private  String confirmPassword;

    public User(String name, String email, String password, String phone, String photo, String role,
                String verification_code, Date code_expires_at, Boolean deleted,int cafe_id, String confirmPassword) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.photo = photo;
        this.role = role;
        this.verification_code = verification_code;
        this.code_expires_at = code_expires_at;
        this.deleted = deleted;
        this.cafe_id = cafe_id;
        this.confirmPassword = confirmPassword;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getVerification_code() {
        return verification_code;
    }

    public void setVerification_code(String verification_code) {
        this.verification_code = verification_code;
    }

    public Date getCode_expires_at() {
        return code_expires_at;
    }

    public void setCode_expires_at(Date code_expires_at) {
        this.code_expires_at = code_expires_at;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public int getCafe_id() {
        return cafe_id;
    }

    public void setCafe_id(int cafe_id) {
        this.cafe_id = cafe_id;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
