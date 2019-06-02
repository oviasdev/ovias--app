package com.example.hp.ovias_mine;

public class BookingCheck {
    String id;
    String username;
    String vehicle;
    String date;
    String time;
    String otp;
    String bill;
    String status;
    public BookingCheck() {
    }

    public BookingCheck(String id, String username, String vehicle, String date, String time,String otp,String bill,String status) {
        this.id = id;
        this.username = username;
        this.vehicle = vehicle;
        this.date = date;
        this.time = time;
        this.otp=otp;
        this.bill=bill;
        this.status=status;
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

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getBill() {
        return bill;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
