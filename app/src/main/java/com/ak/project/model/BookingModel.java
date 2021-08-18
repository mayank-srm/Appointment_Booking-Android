package com.ak.project.model;

import java.util.Date;

/**
 * Created by Mayank on 13,August,2021
 */
public class BookingModel {

    private Date date;
    private String type;


    public BookingModel(String type, Date date) {
        this.type = type;
        this.date = date;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
