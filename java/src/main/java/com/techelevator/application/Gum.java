package com.techelevator.application;

import java.math.BigDecimal;

public class Gum extends VendingItem{
    public Gum(String name, BigDecimal price, String slot, String typeOfItem) {
        super(name, price, slot, typeOfItem);
        //System.out.println("Chewy, Chewy, Lots O Bubbles!");
    }
}
