package com.techelevator.application;

import java.math.BigDecimal;

public class Drink extends VendingItem{
    public Drink(String name, BigDecimal price, String slot, String typeOfItem) {
        super(name, price, slot, typeOfItem);

    }
    public void displayStockInfo() {
        super.displayStockInfo();
        System.out.println("Drinky, Drinky, Slurp, Slurp!");
    }

}
