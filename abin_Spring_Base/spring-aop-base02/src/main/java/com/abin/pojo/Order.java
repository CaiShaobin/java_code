package com.abin.pojo;

public class Order {
    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order() {
    }

    public Order(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
