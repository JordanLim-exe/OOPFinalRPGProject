package models;

import java.io.Serializable;

public class Item implements Serializable {
    protected String name;
    protected String description;

    public Item(String name, String description) {
        setName(name);
        setDescription(description);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "The item: " + getName()  + getDescription();
    }
}
