package models;

public class Weapon extends Item {
    private int weaponDurability;
    private int weaponDamageModifier;

    public Weapon(String name, String description, int weaponDurability, int weaponDamageModifier) {
        super(name, description);
        setWeaponDurability(weaponDurability);
        setWeaponDamageModifier(weaponDamageModifier);
    }

    public int getWeaponDurability() {
        return weaponDurability;
    }

    public void setWeaponDurability(int weaponDurability) {
        this.weaponDurability = weaponDurability;
    }

    public int getWeaponDamageModifier() {
        return weaponDamageModifier;
    }

    public void setWeaponDamageModifier(int weaponDamageModifier) {
        this.weaponDamageModifier = weaponDamageModifier;
    }

    @Override
    public String toString() {
        return "(Weapon)" + super.toString() + "." +
                " It also has a weapon durability " + getWeaponDurability() +
                " and has a bonus damage of " + getWeaponDamageModifier();
    }

}
