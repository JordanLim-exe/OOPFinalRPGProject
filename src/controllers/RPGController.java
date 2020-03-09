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

        while(gameContinues){
            gameContinues = runTurn();
            if(player1.getHp() <= 0) {
                gameContinues = false;
                RPGDisplay.displayMessage("You have Died. GAME OVER");
            }
        }

        if(player1.getHp() >= 1 && RPGDisplay.promptForSave()) {
            runCreateSave();
        }
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
        //Small update needed to fix commits
        String choice = RPGDisplay.promptForDirection(player1);
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
            currentEnemy = new Enemy("Lesser " + enemyNames[rand.nextInt(7)], rand.nextInt(20) + 1, rand.nextInt(10), rand.nextInt(2) + 1);
        }
        else if(bossDifficulty == 1) {
            currentEnemy = new Enemy(enemyNames[rand.nextInt(7)], rand.nextInt(20) + 10, rand.nextInt(10) + 5, rand.nextInt(2) + 2);
        }
        else if(bossDifficulty == 2) {
            currentEnemy = new Enemy("Greater " + enemyNames[rand.nextInt(7)], rand.nextInt(20) + 20, rand.nextInt(10) + 7, rand.nextInt(4) + 2);
        }
        else if(bossDifficulty == 3) {
            currentEnemy = new Enemy("Boss " + enemyNames[rand.nextInt(7)], rand.nextInt(20) + 40, rand.nextInt(10) + 10, rand.nextInt(6) + 3);
        }
        battleLoop();
    }

    public static void battleLoop() {
        boolean battleContinues = true;
        do {
            if(!result()) {
                battleContinues = false;
            }
            else {
                int choice = RPGDisplay.printBattleMenu(currentEnemy, player1);
                if (choice == 4) {
                    if(player1.runAway()) {
                        battleContinues = false;
                    }
                    else{
                        player1.takesDamage(currentEnemy.attack());
                    }
                } else if (choice == 3) {
                    useItem();
                    player1.takesDamage(currentEnemy.attack());
                } else if (choice == 2) {
                    player1.defend(currentEnemy.attack());
                } else if (choice == 1) {
                    currentEnemy.takesDamage(player1.attack());
                    if (currentEnemy.getHp() <= 0) {
                        battleContinues = false;
                    }
                    else {
                        player1.takesDamage(currentEnemy.attack());
                    }
                }
            }
        }while(battleContinues);
        if(player1.getHp() >= 1) {
            Random rand = new Random();
            if(rand.nextInt(20) + 1 >= 12) {
                int chance = rand.nextInt(3);
                if(chance == 0) {
                    player1.addItem(new Potion("Health Potion", " Heals you by 25 after use", 25));

                }
                if(chance == 1) {
                    int rank = rand.nextInt(3);
                    if(rank == 0) {
                        player1.addItem(new Armor("Lesser Armor", " Better than regular clothing, not much else", 50, 10));
                    }
                    else if(rank == 1) {
                        player1.addItem(new Armor("Steel Armor", " Great for protecting the vitals, not good for large threats", 50, 20));
                    }
                    else {
                        player1.addItem(new Armor("God Armor", " The perfect choice for fighting the biggest of threats", 50, 35));
                    }
                }
                if(chance == 2) {
                    int rank = rand.nextInt(3);
                    if(rank == 0) {
                        player1.addItem(new Weapon("Lesser Sword", " Better than just your fists, feels off balance", 50, 10));
                    }
                    else if(rank == 1) {
                        player1.addItem(new Weapon("Steel Sword", " Great for general combat, not special but good enough", 50, 20));
                    }
                    else {
                        player1.addItem(new Weapon("God Sword", " The perfect choice for fighting the biggest of threats", 50, 35));
                    }
                }
                RPGDisplay.itemAdded(chance);
            }
        }

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
            try {
                player1.changeEquipment(RPGDisplay.promptEquip(player1));
            } catch (NullPointerException npe) {
                RPGDisplay.emptyArray();
            }
        }
        if(userChoice == 2) {
            try {
                useItem();
            } catch (NullPointerException npe) {
                RPGDisplay.emptyArray();
            }

        }
        return endApp;
    }

    public static void useItem() {
        int choice = RPGDisplay.promptForConsumable(player1);
        player1.useItem(choice);
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
