package controllers;

import models.Enemy;
import models.FileReader;
import models.Map;
import models.Player;
import view.RPGDisplay;

import java.io.File;

public class RPGController {

    private static Player player1;
    private static Enemy currentEnemy;
    private static Map map;
    private static String saveStateString;

    public static void run() {
        runStartUp();
        boolean gameContinues = true;

        do{
            gameContinues = runTurn();
        }while(gameContinues);
    }

    public static void runStartUp() {
        boolean exists = new File("savestate/save.txt").exists();

        saveStateString = new FileReader().read("journals/save");
        String choice = RPGDisplay.startDisplay(exists);

        saveStateString = "0000000000000";

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
}
