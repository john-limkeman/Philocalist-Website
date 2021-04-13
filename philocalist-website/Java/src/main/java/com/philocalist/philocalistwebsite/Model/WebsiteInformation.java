package com.philocalist.philocalistwebsite.model;

// USED FOR DESERIALIZING CUSTOM WEBSITE DATA

public class WebsiteInformation {
    private int id;
    private String aboutMessage;
    private String aboutImageURL;
    private String email;
    private String phone;
    private String contactMessage;
    private String homeMessage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAboutMessage() {
        return aboutMessage;
    }

    public void setAboutMessage(String aboutMessage) {
        this.aboutMessage = aboutMessage;
    }

    public String getAboutImageURL() {
        return aboutImageURL;
    }

    public void setAboutImageURL(String aboutImageURL) {
        this.aboutImageURL = aboutImageURL;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContactMessage() {
        return contactMessage;
    }

    public void setContactMessage(String contactMessage) {
        this.contactMessage = contactMessage;
    }

    public String getHomeMessage() {
        return homeMessage;
    }

    public void setHomeMessage(String homeMessage) {
        this.homeMessage = homeMessage;
    }
}
