package view;

import models.Map;

public class RPGDisplay {

    public static String startDisplay() {
        //TODO Implement method
        String returnMessage = "METHOD NOT IMPLEMENTED";
        return returnMessage;
    }

    public static void printMap(Map m) {
        for(String[] strings: m.getMapView()){
            System.out.println();
            for(String s : strings){
                System.out.print(s);
            }
        }
    }

    public static void displayInventory() {
        //TODO Implement method
    }

    public static String promptForDirection() {
        //TODO Implement method
        String returnMessage = "METHOD NOT IMPLEMENTED";
        return returnMessage;
    }

    public static void printBattleMenu() {
        //TODO Implement method
    }

    public static void displayMessage(String msg) {
        //TODO Implement method
    }

}
