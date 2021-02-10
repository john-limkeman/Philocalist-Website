package com.philocalist.philocalistwebsite.Model;

import java.util.List;

public class ShoppingCart {
    private List<Stationary> items;

    public void addToCart(Stationary S){
        items.add(S);
    }

}
