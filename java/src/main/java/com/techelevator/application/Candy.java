package com.techelevator.application;

import java.math.BigDecimal;

public class Candy extends VendingItem{
    public Candy(String name, BigDecimal price, String slot, String typeOfItem) {
        super(name, price, slot, typeOfItem);
        //System.out.println("Sugar, Sugar, so Sweet!");
    }
}
