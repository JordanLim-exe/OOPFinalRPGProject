package models;

public class Enemy extends RPGCharacter implements IActionable {

    public Enemy(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }

    @Override
    public int attack() {
        //Takes in roll method
        //If statements depending on condition
        //Check if there's a weapon
        int hit = 0;
        hit = roll(20,1,atk);
        return hit;
    }

    @Override
    public void defend(int attack) {
       hp = hp - (attack / 2);
    }

    @Override
    public String toString() {
        return "(Enemy)" + super.toString();
    }
}
