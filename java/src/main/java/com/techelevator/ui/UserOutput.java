package com.techelevator.ui;

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

    public static void displayInventory(List<String> inventory){
        for(String current : inventory){
        System.out.println(current);
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

}
