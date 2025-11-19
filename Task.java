package com.example.facilita;

public class Task {
    private String description;
    private String status;
    private int user_id;
    private int cafe_id;

    public Task(String description, String status, int user_id, int cafe_id) {
        this.description = description;
        this.status = status;
        this.user_id = user_id;
        this.cafe_id = cafe_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCafe_id() {
        return cafe_id;
    }

    public void setCafe_id(int cafe_id) {
        this.cafe_id = cafe_id;
    }
}
