package models;

import com.sun.org.glassfish.external.statistics.RangeStatistic;
import lib.ConsoleIO;
import view.RPGDisplay;

import java.util.Arrays;
import java.util.Random;

public class Player extends RPGCharacter implements IActionable{

    private Item[] equipInventory;
    private Item[] useInventory;
    private Weapon equippedWeapon;
    private Armor equippedArmor;

    public Player() {
    }

    public Player(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }

    public Player(String name){
        super(name);
    }

    public void changeEquipment(int index){
        index++;
        //Need to access the players getEquipInventory
        //Replace original item with the item the player has selected
        if(equipInventory[index].getClass().getSimpleName().equals("Weapon")){
            Item currentWeapon = equippedWeapon;
            equippedWeapon = (Weapon) equipInventory[index];
            equipInventory[index] = currentWeapon;
        } else{
            Item currentArmor = equippedArmor;
            equippedArmor = (Armor) equipInventory[index];
            equipInventory[index] = currentArmor;
        }

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


    public boolean runAway(){
        Random rng = new Random();
        int min = 1;
        int max = 2;
        int run = rng.nextInt(max - min + 1) + min;

        if(run == 1) {
            //Successfully escaped from battle
            System.out.println("You have successfully escaped the battle. Returning to the world...");
            //Go back into map view
            return true;
        }else{
            //Didn't escape from battle
            System.out.println("You tried to escape but you couldn't. LOL");
            //Return them to fight menu
            return false;
        }
    }

    @Override
    public int attack() {
        //Takes in roll method
        //If statements depending on condition
        //Check if there's a weapon
        int hit = 0;
        hit = roll(1,20,equippedWeapon.getWeaponDamageModifier());
      return hit;
    }

    @Override
    public int defend(int attack) {
       return hp - (attack / 2);
    }

    @Override
    public String toString() {
        return "(Player)" + super.toString();
    }


}
