package models;

import com.sun.org.glassfish.external.statistics.RangeStatistic;
import lib.ConsoleIO;
import view.RPGDisplay;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;

public class Player extends RPGCharacter implements IActionable, Serializable {

    private Item[] equipInventory = new Item[10];
    private Item[] useInventory = new Item[10];
    private Weapon equippedWeapon;
    private Armor equippedArmor;
    private Potion equippedPotion;

    public Player() {
    }

    public Player(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
        equippedWeapon = new Weapon("Your fist: ", "Just a Fist", 50, 0);
        equippedArmor = new Armor("Your clothes: ", "Just the clothes on your back", 50, 0);
    }

    public Player(String name){
        super(name);
    }

    public void changeEquipment(int index){
        if(index != 0) {
            index--;
            //Need to access the players getEquipInventory
            //Replace original item with the item the player has selected
            if (equipInventory[index].getClass().getSimpleName().equals("Weapon")) {
                Item currentWeapon = equippedWeapon;
                equippedWeapon = (Weapon) equipInventory[index];
                equipInventory[index] = currentWeapon;
            } else if (equipInventory[index].getClass().getSimpleName().equals("Armor")) {
                Item currentArmor = equippedArmor;
                equippedArmor = (Armor) equipInventory[index];
                equipInventory[index] = currentArmor;
            }
        }
    }

    public void useItem(int index) {
        if(index != 0) {
            index--;
            if (useInventory[index].getClass().getSimpleName().equals("Potion")) {
                Potion currentPotion = equippedPotion;
                equippedPotion = (Potion) useInventory[index];
                useInventory[index] = currentPotion;
                hp = hp + 25;

                if (hp > 50) {
                    hp = 50;
                }
            }
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

    public void addItem(Item newItem) {
        if(newItem instanceof Armor || newItem instanceof Weapon) {
            boolean itemPlaced = false;
            for (int i = 0; i < 10; i++) {
                if(equipInventory[i] == null && !itemPlaced) {
                    equipInventory[i] = newItem;
                    itemPlaced = true;
                }
            }
        }
        else {
            boolean itemPlaced = false;
            for(int i = 0; i < 10; i++) {
                if(useInventory[i] == null && !itemPlaced) {
                    useInventory[i] = newItem;
                    itemPlaced = true;
                }
            }
        }
    }

    @Override
    public int attack() {
        //Takes in roll method
        //If statements depending on condition
        //Check if there's a weapon
        int hit = 0;
        hit = roll(20,1,equippedWeapon.getWeaponDamageModifier());
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
