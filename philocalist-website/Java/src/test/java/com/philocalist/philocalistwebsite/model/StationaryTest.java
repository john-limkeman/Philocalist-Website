package com.philocalist.philocalistwebsite.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class StationaryTest {

    @Test
    public void testGettersAndSetters(){
        BigDecimal pricey = new BigDecimal(78);
        Stationary stationary = new Stationary();

        stationary.setTheme("Sample Theme");
        stationary.setColor("Purple");
        stationary.setCategory("weddingInvite");
        stationary.setPrice(pricey);
        stationary.setTitle("Sample Title");
        stationary.setPrintType("foil press");
        stationary.setActive(true);
//        stationary.setImgURL("sample url");

        int BDCompare = pricey.compareTo(stationary.getPrice());

        assertEquals("Sample Theme", stationary.getTheme());
        assertEquals("Purple", stationary.getColor());
        assertEquals("weddingInvite", stationary.getCategory());
        assertEquals(0, BDCompare);
        assertEquals("Sample Title", stationary.getTitle());
        assertEquals("foil press", stationary.getPrintType());
        assertEquals(true, stationary.isActive());
//        assertEquals("sample url", stationary.getImgURL());

    }

}