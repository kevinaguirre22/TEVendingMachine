package com.techelevator.application;

import java.math.BigDecimal;

public abstract class VendingItem {
    private String name;
    private BigDecimal price;
    private String slot;
    private String typeOfItem;
    private Integer startingStock = 6;


    public VendingItem(String name, BigDecimal price, String slot, String typeOfItem, Integer startingStock) {
        this.name = name;
        this.price = price;
        this.slot = slot;
        this.typeOfItem = typeOfItem;
        this.startingStock = startingStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getTypeOfItem() {
        return typeOfItem;
    }

    public void setTypeOfItem(String typeOfItem) {
        this.typeOfItem = typeOfItem;
    }

    public Integer getStartingStock() {
        return startingStock;
    }

    public void setStartingStock(Integer startingStock) {
        this.startingStock = startingStock;
    }
}
