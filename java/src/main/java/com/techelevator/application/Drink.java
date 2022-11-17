package com.techelevator.application;

import java.math.BigDecimal;

public class Drink extends VendingItem{
    public Drink(String name, BigDecimal price, String slot, String typeOfItem, Integer startingStock) {
        super(name, price, slot, typeOfItem, startingStock);
        System.out.println("Drinky, Drinky, Slurp Slurp!");
    }
}
