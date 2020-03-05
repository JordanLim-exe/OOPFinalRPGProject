package models;

import com.sun.org.glassfish.external.statistics.RangeStatistic;
import lib.ConsoleIO;

import java.util.Arrays;
import java.util.Random;

public class Player extends RPGCharacter implements IActionable{

    private Item[] equipInventory;
    private Item[] useInventory;

    public Player() {
    }

    public Player(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }

    public Player(String name){
        super(name);
    }

    public void changeWeapon(){
        //Need to access the players getEquipInventory
        //Replace original item with the item the player has selected
    }

    public Item[] getEquipInventory(){
        return equipInventory;
    }

    public Item[] getUseInventory(){
        return useInventory;
    }

    public Item[] returnFullInventory(){
        int length = getEquipInventory().length + getUseInventory().length;

        Item[] fullInventory = new Item[length];
        int pos = 0;
        for (Item item : getUseInventory()) {
            fullInventory[pos] = item;
            pos++;
        }
        for (Item item : getUseInventory()) {
            fullInventory[pos] = item;
            pos++;
        }

        return fullInventory;
    }
}

    }

    public void runAway(){
        Random rng = new Random();
        int min = 1;
        int max = 2;
        int run = rng.nextInt(max - min + 1) + min;

        if(run == 1) {
            //Successfully escaped from battle
            //Go back into map view
        }else{
            //Didn't escape from battle
            //Return them to fight menu
        }
    }

    @Override
    public int attack() {
        //Takes in roll method
        //If statements depending on condition
        //Check if there's a weapon
      return 0;
    }

    @Override
    public int defend(int attack) {
        if(attack < hp){
            //Subtract health and replace original health
            //Resume battle sequence
        }else{
            //Died
            //Return to main menu
        }
        return 0;
    }

    @Override
    public String toString() {
        return "(Player)" + super.toString();
    }


}
