package com.philocalist.philocalistwebsite.model;

import java.math.BigDecimal;
import java.util.List;

public class Stationary {
    private int id; //essentially an item number
    private String category; //Possible categories:
                            // weddingInvite, eventCard, envelope, directionCard,
                            // addressLabel, engageInvite, showerInvite, bachInvite, rehearsalInvite,
                            // thankYou, saveTheDate, {program, menu, placeCard, tableNumber, welcomeSign, favor},
                            // bracketed = {day of items}
                            // BUNDLE ADD-ONS : directionCard, eventCard, rvspOnline, rsvpPrint

    private String title; //name of product for site
    private BigDecimal price; //price per item
    private int theme_id; //design theme
    private String description; //description of stationary item
    private double height; //height in inches
    private double width; //width in inches
    private String color; // color choice within theme
    private String printType; // digital, foilPress, or letterPress
    private String imgURL; //url for display image
    private boolean isActive; //currently available for purchase?


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getTheme_id() {
        return theme_id;
    }

    public void setTheme_id(int theme_id) {
        this.theme_id = theme_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrintType() {
        return printType;
    }

    public void setPrintType(String printType) {
        this.printType = printType;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}
