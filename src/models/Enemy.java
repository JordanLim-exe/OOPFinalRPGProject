package models;

public class Enemy extends RPGCharacter implements IActionable {

    public Enemy(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
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
