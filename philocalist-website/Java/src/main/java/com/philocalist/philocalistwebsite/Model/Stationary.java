package com.philocalist.philocalistwebsite.Model;

import java.math.BigDecimal;
import java.util.Map;

public class Stationary {

        private int id; //essentially an item number
        private String category; //weddingInvite, inviteAddOn, engageInvite, showerInvite, bachInvite, rehearsalInvite,
                                // thankYou, saveTheDate, {program, menu, placeCard, tableNumbers, welcomeSign, favor}, addressLabels
                                // bracketed = {day of items}
        private Map<Integer, BigDecimal> price; //cost ... may need to become a map quantity: price
        private String theme; //design theme
        private String color; // color choice within theme
        private String printType; // digital, foilPress, or letterPress
        private String imgURL; //url for display image




        public void addToCart(int num) {

        }

        public int getId() {
                return id;
        }
        public void setId(int id) {
                this.id = id;
        }
        public String getImgURL() {
                return imgURL;
        }
        public void setImgURL(String imgURL) {
                this.imgURL = imgURL;
        }
        public String getCategory() {
                return category;
        }
        public void setCategory(String type) {
                this.category = type;
        }
        public String getPrintType() {
                return printType;
        }
        public void setPrintType(String printType) {
                this.printType = printType;
        }
        public String getColor() {
                return color;
        }
        public void setColor(String color) {
                this.color = color;
        }
        public String getTheme() {
                return theme;
        }
        public void setTheme(String theme) {
                this.theme = theme;
        }
        public BigDecimal getPrice() {
                return price;
        }
        public void setPrice(BigDecimal price) {
                this.price = price;
        }
}
