package com.example.hp.ovias_mine;

public class AvailabilityCheck {
    private String id;
    private String username;
    private String vehicle;
    private String date;
    private String time;
    private String availability;


    public AvailabilityCheck() {
    }

    public AvailabilityCheck(String id,String username, String vehicle, String date, String time, String availability) {
        this.username = username;
        this.vehicle = vehicle;
        this.date = date;
        this.time = time;
        this.availability = availability;
        this.id=id;

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

    public String getVehicle() {
        return vehicle;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getAvailability() {
        return availability;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
