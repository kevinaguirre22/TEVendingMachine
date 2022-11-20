package com.techelevator.application;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest{

    private VendingMachine vendingMachine;

    @Before
    public void setup(){
        vendingMachine = new VendingMachine();
    }

    //rachelle, eric im so sorry
    @Test
    public void isThereACsv(){
        String actual = vendingMachine.readFile("catering.csv");
        String expected = "File found";
        Assert.assertEquals(expected, actual);
    }


}