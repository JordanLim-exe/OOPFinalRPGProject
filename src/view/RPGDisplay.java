package view;

import lib.ConsoleIO;
import models.Item;
import models.Map;
import models.Player;

public class RPGDisplay {

    public static String startDisplay() {
        System.out.println("Welcome to the Terrain of Magical Expertise, or TOME for short!");
        return ConsoleIO.promptForString("Please enter the name of your player now: ");
    }

    public static void printMap(Map m) {
        for(String[] strings: m.getMapView()){
            System.out.println("-----------------------------");
            for(String s : strings){
                System.out.print(" | " + s + " | ");
            }
        }
        System.out.println("-----------------------------");
    }

    public static void displayInventory(Player p) {
        System.out.println("Your inventory: ");
        for(Item i : p.returnFullInventory()){
            System.out.println(i.toString());
        }
    }

    public static String promptForDirection() {
        boolean isValid = false;
        String direction;
        do {
            String prompt = "Using wasd, please select the direction you would like to travel: ";
            direction = ConsoleIO.promptForString(prompt);
            if(direction.trim().equals("w")||direction.trim().equals("a")||direction.trim().equals("s")||direction.trim().equals("d")){
                isValid=true;
            } else{
                System.out.println("Please input w, a, s, or d.");
            }
        }while(!isValid);


        return direction;
    }

    public static int printBattleMenu() {
        //attack, def, use item, run away
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

    public static void displayMessage(String msg) {
        System.out.println(msg);
    }

}
