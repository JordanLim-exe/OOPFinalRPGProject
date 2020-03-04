package controllers;

import models.Enemy;
import models.FileReader;
import models.Map;
import models.Player;

import java.io.File;

public class RPGController {

    private Player player1;
    private Enemy currentEnemy;
    private Map map;
    private String saveStateString;

    public void run() {
        runStartUp();
        boolean gameContinues = true;

        do{
            gameContinues = runTurn();
        }while(gameContinues);
    }

    public void runStartUp() {
        boolean exists = new File("savestate/save.txt").exists();
        if(exists) {
            saveStateString = new FileReader().read("journals/save");
        }
        else {
            saveStateString = "0000000000000";
        }
    }

    public boolean runTurn() {
        return true;
    }

    public void battleStart(int bossDifficulty) {

    }

    public void battleLoop() {

    }

    public boolean result() {
        return true;
    }
}
