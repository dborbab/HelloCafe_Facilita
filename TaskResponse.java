package com.example.facilita;

import java.util.List;

public class TaskResponse {

    int code;
    String type;
    String status;
    String message;
    List<Task> data;

    public TaskResponse(int code, String type, String status, String message, List<Task> data) {
        this.code = code;
        this.type = type;
        this.status = status;
        this.message = message;
        this.data = data;
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

    public List<Task> getData() {
        return data;
    }

    public void setData(List<Task> data) {
        this.data = data;
    }
}
