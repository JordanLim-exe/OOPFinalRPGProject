package models;

public class Potion extends Item {
    private int attributeModifier;

    public Potion(String name, String description, int attributeModifier) {
        super(name, description);
       setAttributeModifier(attributeModifier);
    }

    public int getAttributeModifier() {
        return attributeModifier;
    }

    public void setAttributeModifier(int attributeModifier) {
        this.attributeModifier = attributeModifier;
    }

    @Override
    public String toString() {
        return "(Potion)" + super.toString() + "." +
                " It also has an attribute modifier of " + getAttributeModifier();
    }
}
