package com.codecool.web.model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class Attendance {
    private User user;
    private Date date;
    private String present;

    public Attendance(User user, Date date, String present) {
        this.user = user;
        this.date = date;
        this.present = present;
    }

    public User getUser() {
        return user;
    }

    public String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY - MM - dd");
        Date date = new Date(System.currentTimeMillis());
        return dateFormat.format(date);
    }

    public String getPresent() {
        return present;
    }
}
