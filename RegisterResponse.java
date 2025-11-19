package com.example.facilita;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {

    int code;
    String type;
    String status;
    String message;
    @SerializedName("data")
    DataRegister dataRegister;


}
