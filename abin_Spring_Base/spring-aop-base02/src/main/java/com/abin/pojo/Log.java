package com.abin.pojo;

public class Log {
    int orderId;
    String desc;
    String result;

    public Log(int orderId, String desc, String result) {
        this.orderId = orderId;
        this.desc = desc;
        this.result = result;
    }

    public Log() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
