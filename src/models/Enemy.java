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
        return 0;
    }

    @Override
    public int defend(int attack) {
        if(attack < hp){
            //Subtract health and replace original health
            //Resume battle sequence
        }else{
            //Died
            //Return to main menu
        }
        return 0;
    }

    @Override
    public String toString() {
        return "(Enemy)" + super.toString();
    }
}
