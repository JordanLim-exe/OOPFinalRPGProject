package models;

public class RPGCharacter {
    protected String name;
    protected int hp;
    protected int atk;
    protected int def;

    public RPGCharacter(String name, int hp, int atk, int def) {
        setName(name);
        setHp(hp);
        setAtk(atk);
       setDef(def);
    }

    public RPGCharacter(){}

    public RPGCharacter(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int roll(int numOfSides, int numOfDice, int modifier){
        return 2;
    }

    @Override
    public String toString() {
        return "RPGCharacter{" +
                "name='" + getName() + '\'' +
                ", hp=" + getHp() +
                ", atk=" + getAtk() +
                ", def=" + getDef() +
                '}';
    }
}
