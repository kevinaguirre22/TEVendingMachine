package com.techelevator.application;

import java.math.BigDecimal;

public class Munchy extends VendingItem{
    public Munchy(String name, BigDecimal price, String slot, String typeOfItem) {
        super(name, price, slot, typeOfItem);
        //System.out.println("Munchy, Munchy, so Good!");
    }
}
