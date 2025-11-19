package com.example.facilita;

import java.util.Date;

public class Product {

    private String name;
    private int unit;
    private int stock_quantity;
    private int stck_min;
    private int deleted;
    private int category_id;
    private int cafe_id;



    public Product(String name, int stock_quantity, int unit, int stck_min, int deleted, int category_id, int cafe_id) {

        this.name = name;
        this.stock_quantity = stock_quantity;
        this.unit = unit;
        this.stck_min = stck_min;
        this.deleted = deleted;
        this.category_id = category_id;
        this.cafe_id = cafe_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public int getStck_min() {
        return stck_min;
    }

    public void setStck_min(int stck_min) {
        this.stck_min = stck_min;
    }

    public int isDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getCafe_id() {
        return cafe_id;
    }

    public void setCafe_id(int cafe_id) {
        this.cafe_id = cafe_id;
    }
}
