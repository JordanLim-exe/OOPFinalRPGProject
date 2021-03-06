package models;

import java.io.Serializable;

public class Armor extends Item implements Serializable {

    private int armorDurability;
    private int healthModifier;

    public Armor(String name, String description, int armorDurability, int healthModifier) {
        super(name, description);
        setArmorDurability(armorDurability);
        setHealthModifier(healthModifier);
    }

    public int getArmorDurability() {
        return armorDurability;
    }

    public void setArmorDurability(int armorDurability) {
        this.armorDurability = armorDurability;
    }

    public int getHealthModifier() {
        return healthModifier;
    }

    public void setHealthModifier(int healthModifier) {
        this.healthModifier = healthModifier;
    }

    @Override
    public String toString() {
        return "(Armor)" + super.toString() + "." +
                " It also has an armor durability " + getArmorDurability() +
                " and has a health bonus of " + getHealthModifier();
    }
}
