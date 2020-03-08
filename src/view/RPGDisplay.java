package view;

import lib.ConsoleIO;
import models.Item;
import models.Map;
import models.Player;

public class RPGDisplay {

    public static int startDisplay(boolean saveExists) {
        String[] optionsSave = {
                "New game",
                "Continue"
        };
        String[] options = {
                "New game"
        };
        int choice;
        if(saveExists) {
            System.out.println("Welcome back to TOME! Select one of the choices below");
            choice = ConsoleIO.promptForMenuSelection(optionsSave, true);
        } else{
            System.out.println("Welcome to the Terrain of Magical Expertise, or TOME for short!");
            choice = ConsoleIO.promptForMenuSelection(options, true);
        }
        return choice;
    }

    public static int mainMenu(){
        String[] options ={
              "Change equipment",
              "Use item",
              "Go back"
        };
        return ConsoleIO.promptForMenuSelection(options, true);
    }

    public static void printMap(Map m) {
        int playerX = 0;
        int playerY = 0;
        for (int j = 4; j > -1; j--) {
            String[] strings = m.getMapView()[j];
            playerX = 0;
            playerY++;
            System.out.println("\n  --------------------------------");
            for (int i = 4; i > -1; i--) {
                String s = strings[i];
                playerX++;
                if(playerX == 3 && playerY == 3){
                    System.out.print("  |  " + "P");
                }else {
                    System.out.print("  |  " + s);
                }
            }
            System.out.print("  | ");
        }
        System.out.println("\n  --------------------------------");
    }

    public static void printMainMap(Map m) {
            for(String[] strings: m.getMainMap()){
                System.out.println();
                for(String s : strings){
                    System.out.print(" " + s + " ");
                }
            }
        System.out.println();
    }

    public static void displayFullInventory(Player p) {
        System.out.println("Your inventory: ");
        for(Item i : p.returnFullInventory()){
            System.out.println(i.toString());
        }
    }

    public static void displayEquipInventory(Player p) {
        System.out.println("Your equippable inventory: ");
        for(Item i : p.getEquipInventory()){
            System.out.println(i.toString());
        }
    }

    public static String[] displayUseInventory(Player p) {
        System.out.println("Your consumable inventory: ");
        String[] options =new  String[p.getUseInventory().length];
        int counter = 0;
        for(Item i : p.getUseInventory()){
            System.out.println(i.toString());
            options[counter] = i.toString();
            counter++;
        }
        return options;
    }

    public static int promptForConsumable(String[] options){
        System.out.println("Please select the consumable you would like to use: ");
        return ConsoleIO.promptForMenuSelection(options, true);
    }

    public static String promptForName(){
        return ConsoleIO.promptForString("Please enter the name you would like to go by: ");
    }

    public static String promptForDirection() {
        boolean isValid = false;
        String direction;
        do {
            String prompt = "Using wasd, please select the direction you would like to travel, or input 0 for the menu: ";
            direction = ConsoleIO.promptForString(prompt);
            if(direction.trim().equals("w")||direction.trim().equals("a")||direction.trim().equals("s")||direction.trim().equals("d")||direction.trim().equals("0")){
                isValid=true;
            } else{
                System.out.println("Please input w, a, s, d, or 0.");
            }
        }while(!isValid);


        return direction;
    }

    public static int printBattleMenu() {
        System.out.println("You have encountered an enemy. Choose one of the option below: ");
        String[] options = {
                "Attack",
                "Defend",
                "Use item",
                "Run away"
        };
        int choice = ConsoleIO.promptForMenuSelection(options, false);
        return choice;
    }

    public static int promptEquip(Player p){
        String[] options = new String[p.getEquipInventory().length];
        for (int i = 0; i < options.length; i++) {
            options[i] = p.getEquipInventory()[i].toString();
        }
        return ConsoleIO.promptForMenuSelection(options,true);
    }

    public static void displayMessage(String msg) {
        System.out.println(msg);
    }

}
