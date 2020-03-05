package controllers;

import models.*;
import view.RPGDisplay;

import java.io.*;

public class RPGController {

    private static Player player1 = new Player();
    private static Enemy currentEnemy;
    private static Map map;
    private static boolean gameContinues = true;
    private static Game saveState;

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
            player1 = new Player(RPGDisplay.promptForName());
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
        return true;
    }

    public static void battleStart(int bossDifficulty) {

    }

    public static void battleLoop() {

    }

    public static boolean result() {
        return true;
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
}
