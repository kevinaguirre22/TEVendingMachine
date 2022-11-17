package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VendingMachine 
{
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
                System.out.println(text);
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

            public void getVendingItem(){

        }

        }
    }
    
}
