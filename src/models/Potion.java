package models;

public class Potion extends Item {
    private int attributeModifier;

    public Potion(String name, String description, int attributeModifier) {
        super(name, description);
        this.attributeModifier = attributeModifier;
    }

    public int getAttributeModifier() {
        return attributeModifier;
    }

    public void setAttributeModifier(int attributeModifier) {
        this.attributeModifier = attributeModifier;
    }

    @Override
    public String toString() {
        return "Potion{" +
                "attributeModifier=" + attributeModifier +
                '}';
    }
}
