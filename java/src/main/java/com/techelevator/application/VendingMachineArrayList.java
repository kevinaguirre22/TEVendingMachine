//package com.techelevator.application;
//
//import com.techelevator.ui.UserInput;
//import com.techelevator.ui.UserOutput;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.math.BigDecimal;
//import java.util.*;
//
//public class VendingMachine
//{
//    //private Map<String, String> itemMap = new HashMap<>();
//    private List<String> inventory = new ArrayList<>();
//    public void run()
//    {
//        Scanner scan = new Scanner(System.in);
//        //test driven development to read the file
//        System.out.println("Enter the file path for your text file");
//        String fileInput = scan.nextLine();
//        File fileName = new File(fileInput);
//
//        try(Scanner fileScanner = new Scanner(fileName)){
//            while(fileScanner.hasNextLine()){
//                String text = fileScanner.nextLine();
//                String[] array = text.split(",");
//                String slotID = array[0];
//                String name = array[1];
//                String price = array[2];
//                String type = array[3];
//
//                if(type.equals("Gum"))
//                {
//                    Gum gum = new Gum(name, new BigDecimal(price), slotID, type);
//                    //itemMap.put(slotID, gum.getName());
//                    inventory.add("Slot Identifier: " + gum.getSlot());
//                    inventory.add("Item Name: " + gum.getName());
//                    inventory.add("Remaining: " + gum.getStartingStock().toString() + "\n");
//                }
//                else if(type.equals("Drink"))
//                {
//                    Drink drink = new Drink(name, new BigDecimal(price), slotID, type);
//                    //itemMap.put(slotID,drink.getName());
//                    inventory.add("Slot Identifier: " + drink.getSlot());
//                    inventory.add("Item Name: " + drink.getName());
//                    inventory.add("Remaining: " + drink.getStartingStock().toString() + "\n");
//                }
//                else if(type.equals("Munchy"))
//                {
//                    Munchy munchy = new Munchy(name, new BigDecimal(price), slotID, type);
//                    //itemMap.put(slotID,munchy.getName());
//                    inventory.add("Slot Identifier: " + munchy.getSlot());
//                    inventory.add("Item Name: " + munchy.getName());
//                    inventory.add("Remaining: " + munchy.getStartingStock().toString() + "\n");
//                }
//                else if(type.equals("Candy"))
//                {
//                    Candy candy = new Candy(name, new BigDecimal(price), slotID, type);
//                    //itemMap.put(slotID,candy.getName());
//                    inventory.add("Slot Identifier: " + candy.getSlot());
//                    inventory.add("Item Name: " + candy.getName());
//                    inventory.add("Remaining: " + candy.getStartingStock().toString() + "\n");
//                }
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
//        }
//
//        while(true)
//        {
//            UserOutput.displayHomeScreen();
//            String choice = UserInput.getHomeScreenOption();
//
//            if(choice.equals("display"))
//            {
//                // display the vending machine slots
//                UserOutput.displayInventory(this.inventory);
//            }
//            else if(choice.equals("purchase"))
//            {
//                String choice2 = "";
//                BigDecimal total= BigDecimal.valueOf(0);
//                while(true){
//
//                    if(choice2.equals("")){
//                        UserOutput.displayPurchasingScreen();
//                        choice2 = UserInput.getPurchasingScreenOption(total);
//                    }
//                    if (choice2.equals("feed money")){
//                        while(true){
//
//                            String decision;
//                            do{
//
//                                System.out.println("What bill are you putting in: 1, 5, 10, 20");
//                                String input = scan.nextLine();
//                                BigDecimal inputBD = new BigDecimal(input);
//
//                                total = total.add(inputBD);
//
//                                System.out.println("Are you finished?");
//                                decision = scan.nextLine();
//
//                                if(decision.equalsIgnoreCase("y")) {
//                                    UserInput.getPurchasingScreenOption(total);
//                                    break;
//                                }
//                            }
//                            while(decision.equals("N"));
//                            System.out.println("Total amount entered: " + total);
//                            choice2 = "select item";
//                            break;
//                        }
//
//                    } if (choice2.equals("select item")){
//                        System.out.println();
//                        UserOutput.displaySelectingItemScreen();
//
//                    }if (choice2.equals("finish transaction")){
//                        UserOutput.displayInventory(this.inventory);
//                        System.out.println("Enter slot number to select your item");
//                        String slotChoice = scan.nextLine();
//                        for(String currentSlot : inventory){
//
//                        }
//                        if(this.inventory().equals!= )
//                        //has an infinite loop if else is stated
//                    } else {
//                        break;
//                    }
//                }
//                // make a purchase
//            }
//            else if(choice.equals("exit"))
//            {
//                // good bye
//                break;
//            }
//
//
//
//        }
//    }
//
//}
