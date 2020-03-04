package controllers;

import models.Enemy;
import models.Map;
import models.Player;
import view.RPGDisplay;

public class RPGController {

    private Player player1;
    private Enemy currentEnemy;
    private Map map;

    public void run() {
        runStartUp();
        boolean gameContinues = true;

        do{

        }while(gameContinues);
    }

    public void runStartUp() {
map.movePlayer("d");
RPGDisplay.printMap(map);
    }

    public int runTurn() {
return 0;
    }

    public void battleStart(int bossDifficulty) {

    }

    public void battleLoop() {

    }

    public boolean result() {
return false;
    }
}
