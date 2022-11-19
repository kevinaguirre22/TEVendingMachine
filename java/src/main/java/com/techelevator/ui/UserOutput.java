package com.techelevator.ui;

import com.techelevator.application.VendingItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput
{

    public static void displayMessage(String message)
    {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayHomeScreen()
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void displayInventory(Map<String, VendingItem> inventory){
        for(Map.Entry<String,VendingItem>  current : inventory.entrySet()){
            System.out.println(current.getKey() + ": " + current.getValue().getName() + " - " + current.getValue().getStartingStock() + " remaining");
            System.out.println();
         }
    }

    public static void displayPurchasingScreen()
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                   Purchase Menu");
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }

//    public static void displayPrice(BigDecimal price){
//        System.out.println(price);
//    }
    public static void displaySelectingItemScreen(){
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("               Select An Item, ya dingus");
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }

    public static void displayVendingMessage(){

    }

}
