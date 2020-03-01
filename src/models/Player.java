package models;

public class Player extends RPGCharacter implements IActionable{

    private Item[] equipInventory;
    private Item[] useInventory;

    public Player() {
    }

    public Player(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }

    public Player(String name){
        super(name);
    }

    public void runAway(){

    }

    public void changeWeapon(){

    }

    public Item[] getEquipInventory(){
        return new Item[0];
    }

    public Item[] getUseInventory(){
        return new Item[0];
    }

    public Item[] returnFullInventory(){
        return new Item[0];
    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defend(int attack) {
        return 0;
    }
}
