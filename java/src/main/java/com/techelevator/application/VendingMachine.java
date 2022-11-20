package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class VendingMachine 
{
    private Map<String, VendingItem> inventory = new HashMap<>();
    BigDecimal total = new BigDecimal ("0");
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
                System.out.println();
                UserOutput.displayInventory(inventory);

            }
            else if(choice.equals("purchase"))
            {   int counter = 0;
                String choice2 = "";
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
                          //  if(!input.contains("1") && !input.contains("5") && !input.contains("10") && !input.contains("20")){
                            //    System.out.println("Invalid bill");
                           // }
                            BigDecimal inputBD = new BigDecimal(input);

                            total = total.add(inputBD);
                            LocalDateTime nowLDT = LocalDateTime.now();
                            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                            String formatNow = nowLDT.format(format);

                            UserOutput.writingToFile(formatNow + "\tMONEY FED:\t" + input + "\t" + total);
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
                    if(slotChoice.equalsIgnoreCase("Q")){
                        break;
                    }


                        for(Map.Entry<String,VendingItem>  current : inventory.entrySet()){
                        String slotId = current.getKey();
                        BigDecimal balance = total;


                        if (slotChoice.equalsIgnoreCase(slotId) && current.getValue().getStartingStock() > 0){
                            counter++;
                            total = total.subtract(current.getValue().getPrice());
                            current.getValue().displayStockInfo();
                            if(counter % 2 == 0){
                                //BigDecimal bogodo = current.getValue().getPrice().subtract(new BigDecimal("1.00"));
                                total = total.add(new BigDecimal("1.00"));
                            }
                            //Andy recommended getting the audit data at this point.
                            LocalDateTime nowLDT = LocalDateTime.now();
                            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                            String formatNow = nowLDT.format(format);
                            UserOutput.writingToFile(formatNow + "\t" + current.getValue().getName() + "\t" + slotId + "\t" +  balance + "\t" + total );


                            System.out.println("You have a balance of: " + total);
                            //UserOutput.displayPurchasingScreen();
                            //UserInput.getPurchasingScreenOption(total);

                        } else if(slotChoice.equalsIgnoreCase(slotId) && current.getValue().getStartingStock() <= 0){
                            current.getValue().displayUnavailableStockInfo();
                        } /*else if (!slotChoice.equals(slotId)){
                            current.getValue().displayInvalidSlotChoice(slotChoice);
                        }*/
/*                        if(!slotChoice.equals(slotId)){
                            System.out.println("Invalid Slot Choice, ya goon! Make Better Choices Next Time!");
                        }*/
                       /* if (!slotChoice.equals(slotId)){
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
                    String moneyBeforeChange = String.valueOf(total);

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
                        LocalDateTime nowLDT = LocalDateTime.now();
                        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                        String formatNow = nowLDT.format(format);
                        UserOutput.writingToFile(formatNow + "\tCHANGE GIVEN:\t" + moneyBeforeChange + "\t0.00");

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
