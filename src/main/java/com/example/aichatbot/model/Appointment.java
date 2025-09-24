package com.example.aichatbot.model;

public class Appointment {
    private String userName;
    private String userEmail;
    private String appointmentDate;

    public Appointment(String userName, String userEmail, String appointmentDate) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.appointmentDate = appointmentDate;
    }

    // getters and setters

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}
