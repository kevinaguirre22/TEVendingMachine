package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class VendingMachine 
{
    private Map<String, VendingItem> inventory = new HashMap<>();
    public void run()
    {
        Scanner scan = new Scanner(System.in);
        readFile();

        while(true)
        {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if(choice.equals("display"))
            {
                // display the vending machine slots
                UserOutput.displayInventory(inventory);
            }
            else if(choice.equals("purchase"))
            {
                String choice2 = "";
                BigDecimal total = BigDecimal.valueOf(0);
                while(true){

                if(choice2.equals("")){
                    UserOutput.displayPurchasingScreen();
                    choice2 = UserInput.getPurchasingScreenOption(total);
                    }
                if (choice2.equals("feed money")){
                    while(true){

                        String decision;
                        do{

                            System.out.println("What bill are you putting in: 1, 5, 10, 20");
                            String input = scan.nextLine();
                            BigDecimal inputBD = new BigDecimal(input);

                            total = total.add(inputBD);
                            UserOutput.writingToFile("Adding money");
                            System.out.println("Are you finished?");
                            decision = scan.nextLine();

//                            if(decision.equalsIgnoreCase("y")) {
//                                UserInput.getPurchasingScreenOption(total);
//                                break;
//                            }
                        }
                        while(decision.equals("N"));
                        System.out.println("Total amount entered: " + total);
                        choice2 = "";
                        break;
                    }

                } if (choice2.equals("select item")){
                    System.out.println();
                    UserOutput.displaySelectingItemScreen();
                    UserOutput.displayInventory(inventory);
                    System.out.println("Enter slot number to select your item");
                    String slotChoice = scan.nextLine();
                    int counter = 0;

                    for(Map.Entry<String,VendingItem>  current : inventory.entrySet()){
                        String slotId = current.getKey();
//                        BigDecimal balance = total.subtract(current.getValue().getPrice());

                        if (slotChoice.equals(slotId)){
                            counter++;
                            total = total.subtract(current.getValue().getPrice());
                            current.getValue().displayStockInfo();
                            //Andy recommended getting the audit data at this point.
                            UserOutput.writingToFile("Purchased something");
                            System.out.println("You have a balance of: " + total);
                            UserOutput.displayPurchasingScreen();
                            UserInput.getPurchasingScreenOption(total);
                                if(total.equals(0)){
                                    System.out.println("out of funds");
                                }
                        } /*else {
                            System.out.println("Invalid Slot Choice, ya goon! Make Better Choices Next Time!");
                            UserOutput.displayPurchasingScreen();
                            UserInput.getPurchasingScreenOption(total);
                            break;
                        }*/

                    }

                } if (choice2.equals("finish transaction")){
                    int dollars = 0;
                    int quarters = 0;
                    int dimes = 0;
                    int nickels = 0;

                    while(total.compareTo(new BigDecimal("0")) > 0){
                        if(total.compareTo(new BigDecimal("1")) >= 0){
                            dollars++;
                            total = total.subtract(new BigDecimal("1"));
                        } else if (total.compareTo(new BigDecimal("0.25")) >= 0){
                            quarters++;
                            total = total.subtract(new BigDecimal("0.25"));
                        } else if (total.compareTo(new BigDecimal("0.10")) >= 0){
                            dimes++;
                            total = total.subtract(new BigDecimal("0.10"));
                        } else if (total.compareTo(new BigDecimal("0.05")) >= 0){
                            nickels++;
                            total = total.subtract(new BigDecimal("0.05"));
                        }
                    }
                        System.out.println("Your change is " + "(" + dollars + ") dollars, " + "(" + quarters + ") quarters, " + "(" + dimes + ") dimes, " + "(" + nickels + ") nickels.") ;
                        break;
                }

                }
                // make a purchase
            }
            else if(choice.equals("exit"))
            {
                // good bye
                break;
            }



        }
    }

    public void readFile(){
        //test driven development to read the file
        File fileName = new File("catering.csv");

        try(Scanner fileScanner = new Scanner(fileName)){
            while(fileScanner.hasNextLine()){
                String text = fileScanner.nextLine();
                String[] array = text.split(",");
                String slotID = array[0];
                String name = array[1];
                String price = array[2];
                String type = array[3];

                if(type.equals("Gum"))
                {
                    Gum gum = new Gum(name, new BigDecimal(price), slotID, type);
                    inventory.put(gum.getSlot(), gum);
                }
                else if(type.equals("Drink"))
                {
                    Drink drink = new Drink(name, new BigDecimal(price), slotID, type);
                    inventory.put(drink.getSlot(), drink);
                }
                else if(type.equals("Munchy"))
                {
                    Munchy munchy = new Munchy(name, new BigDecimal(price), slotID, type);
                    inventory.put(munchy.getSlot(), munchy);
                }
                else if(type.equals("Candy"))
                {
                    Candy candy = new Candy(name, new BigDecimal(price), slotID, type);
                    inventory.put(candy.getSlot(), candy);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }


    
}
