package com.example.hp.ovias_mine;

public class TransactionCheck {
    private String id;
    private String username;
    private String vehicle;
    private String date;
    private String time;
    private String transactionId;
    public TransactionCheck() {
    }

    public TransactionCheck(String id, String username, String vehicle, String date, String time, String transactionId) {
        this.id = id;
        this.username = username;
        this.vehicle = vehicle;
        this.date = date;
        this.time = time;
        this.transactionId = transactionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
