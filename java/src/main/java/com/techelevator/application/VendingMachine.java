package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachine 
{
    //private Map<String, String> itemMap = new HashMap<>();
    private List<String> inventory = new ArrayList<>();
    public void run()
    {
        Scanner scan = new Scanner(System.in);
        //test driven development to read the file
        System.out.println("Enter the file path for your text file");
        String fileInput = scan.nextLine();
        File fileName = new File(fileInput);

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
                    //itemMap.put(slotID, gum.getName());
                    inventory.add(gum.getSlot());
                    inventory.add(gum.getName());
                    inventory.add(gum.getStartingStock().toString());
                }
                else if(type.equals("Drink"))
                {
                    Drink drink = new Drink(name, new BigDecimal(price), slotID, type);
                    //itemMap.put(slotID,drink.getName());
                    inventory.add(drink.getSlot());
                    inventory.add(drink.getName());
                    inventory.add(drink.getStartingStock().toString());
                }
                else if(type.equals("Munchy"))
                {
                  Munchy munchy = new Munchy(name, new BigDecimal(price), slotID, type);
                    //itemMap.put(slotID,munchy.getName());
                    inventory.add(munchy.getSlot());
                    inventory.add(munchy.getName());
                    inventory.add(munchy.getStartingStock().toString());
                }
                else if(type.equals("Candy"))
                {
                    Candy candy = new Candy(name, new BigDecimal(price), slotID, type);
                    //itemMap.put(slotID,candy.getName());
                    inventory.add(candy.getSlot());
                    inventory.add(candy.getName());
                    inventory.add(candy.getStartingStock().toString());
                }

                //System.out.println(slotID + " " + name + " " + price);
                //System.out.println(inventory);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        while(true)
        {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();


            if(choice.equals("display"))
            {

                //step 5 goes here
                // display the vending machine slots
                UserOutput.displayInventory(this.inventory);
                //UserOutput.

            }
            else if(choice.equals("purchase"))
            {
                while(true){
                UserOutput.displayPurchasingScreen();
                String choice2 = UserInput.getPurchasingScreenOption();
                if (choice2.equals("feed money")){
                    while(true){
                        System.out.println("What bill are you putting in: 1, 5, 10, 20");
                        BigDecimal bill = scan.nextBigDecimal();
                        System.out.println("Are you finished?");
                        String decision = scan.nextLine();
                        BigDecimal money = BigDecimal.valueOf();
                    }
                } else if (choice2.equals("select item")){

                } else if (choice2.equals("finish transaction")){

                } else {
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
    
}
