package controllers;

import models.*;
import view.RPGDisplay;

import java.io.*;
import java.util.Random;

public class RPGController {

    private static Player player1 = new Player();
    private static Enemy currentEnemy;
    private static Map map = new Map();
    private static boolean gameContinues = true;
    private static Game saveState;
    private static String[] enemyNames = {"Slime", "Goblin", "Hobgoblin", "Skeleton", "Sexy Goblin?", "'B' Swarm", "Orca"};

    public static void run() {
        runStartUp();

        do{
            gameContinues = runTurn();
        }while(gameContinues);

        runCreateSave();
    }

    public static void runStartUp() {
        boolean saveExists = true;
        String fileName = "Save.txt";
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            saveState = (Game) in.readObject();

            in.close();
            file.close();
        }catch (ClassNotFoundException | FileNotFoundException nA) {
            saveExists = false;
        }catch (IOException ioe) {
            saveExists = false;
        }

        int choice = RPGDisplay.startDisplay(saveExists);

        if(choice == 0) {
            gameContinues = false;
        }
        else if(choice == 1) {
            player1 = new Player(RPGDisplay.promptForName(), 50, 5, 5);
            map.setPlayerPositionX(9);
            map.setPlayerPositionY(9);
        }
        else if(choice == 2) {
            player1 = saveState.getUser();
            map.setPlayerPositionX(saveState.getPlayerPositionX());
            map.setPlayerPositionY(saveState.getPlayerPositionY());
        }

    }

    public static boolean runTurn() {
        boolean boolReturn = true;
        RPGDisplay.printMap(map);
        String choice = RPGDisplay.promptForDirection();
        if(choice.equals("0")) {
            if(menu()) {
                boolReturn = false;
            }
        }
        else {
            determineEncounter(map.movePlayer(choice));
        }
        return boolReturn;
    }

    public static void battleStart(int bossDifficulty) {
        Random rand = new Random();
        if(bossDifficulty == 0) {
            currentEnemy = new Enemy(enemyNames[rand.nextInt(7)], rand.nextInt(20) + 1, rand.nextInt(10) + 5, rand.nextInt(10) + 5);
        }
    }

    public static void battleLoop() {


    }

    public static boolean result() {
        if(player1.getHp() <= 0) {
            gameContinues = false;
        }
        return gameContinues;
    }

    public static void runCreateSave() {
        saveState = new Game(player1, map.getPlayerPositionX(), map.getPlayerPositionY());
        String fileName = "Save.txt";

        try {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(saveState);

            out.close();
            file.close();
        } catch (IOException ioe) {
            System.out.println("IOException is caught");
        }
    }

    public static boolean menu() {
        boolean endApp = false;
        int userChoice = RPGDisplay.mainMenu();
        if(userChoice == 0) {
            endApp = true;
        }
        if(userChoice == 1) {
            player1.changeEquipment(RPGDisplay.promptEquip(player1));
        }
        if(userChoice == 2) {
            useItem();
        }
        return endApp;
    }

    public static void useItem() {
        //RPGDisplay.promptForConsumable(player1.)
    }

    public static void determineEncounter(String tile) {
        if(tile.equals("D")) {
            battleStart(3);
        }
        else {
            if (tile.equals("T") || tile.equals("W") || tile.equals("@")) {
                player1.setHp(50);
            }
            else {
                Random rand = new Random();
                int chance = rand.nextInt(20) + 1;
                switch (tile) {
                    case "~":
                        if (chance > 12) {
                            battleStart(0);
                        }
                        break;
                    case "*":
                        if (chance > 12) {
                            battleStart(1);
                        }
                        break;
                    case "-":
                        if (chance > 12) {
                            battleStart(2);
                        }
                        break;
                }
            }
        }
    }

    public static void test() {

    }

}
