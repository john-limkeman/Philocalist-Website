package com.philocalist.philocalistwebsite.Model;

import java.math.BigDecimal;

public class Stationary {

        private String category; //weddingInvite, inviteAddOn, engageInvite, showerInvite, bachInvite, rehearsalInvite,
                                // thankYou, saveTheDate, {program, menu, placeCard, tableNumbers, welcomeSign, favor}, addressLabels
                                // bracketed = {day of items}
        private BigDecimal price; //cost ... may need to become a map quantity: price
        private String theme; //design theme
        private String color; // color choice within theme
        private String printType; // digital, foilPress, or letterPress
        private String imgURL; //url for display image




        public void addToCart(int num) {

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
