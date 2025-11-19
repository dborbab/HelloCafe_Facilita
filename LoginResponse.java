package com.example.facilita;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginResponse {

    int code;
    String type;
    String status;
    String message;
    @SerializedName("data")
    DataLogin dataLogin;

    public LoginResponse(int code, String type, String status, String message, DataLogin dataLogin) {
        this.code = code;
        this.type = type;
        this.status = status;
        this.message = message;
        this.dataLogin = dataLogin;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataLogin getDataLogin() {
        return dataLogin;
    }

    public void setDataLogin(DataLogin dataLogin) {
        this.dataLogin = dataLogin;
    }
}
