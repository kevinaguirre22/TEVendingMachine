package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine 
{
    private Map<String, VendingItem> itemMap = new HashMap<>();

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
                if(array[3].equals("Gum"))
                {
                    Gum gum = new Gum(name, new BigDecimal(price), slotID, array[3]);
                    itemMap.put(slotID, VendingItem.getName());
                }
                if(array[3].equals("Drink"))
                {
                    Drink drink = new Drink(name, new BigDecimal(price), slotID, array[3]);
                    itemMap.put(slotID,drink);
                }
                if(array[3].equals("Munchy"))
                {
                  Munchy munchy = new Munchy(name, new BigDecimal(price), slotID, array[3]);
                    itemMap.put(slotID,munchy);
                }
                if(array[3].equals("Candy"))
                {
                    Candy candy = new Candy(name, new BigDecimal(price), slotID, array[3]);
                    itemMap.put(slotID,candy);
                }

                //System.out.println(slotID + " " + name + " " + price);
                System.out.println(itemMap);
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
            }
            else if(choice.equals("purchase"))
            {
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
