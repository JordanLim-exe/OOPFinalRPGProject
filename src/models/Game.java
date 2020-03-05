package models;

import java.io.Serializable;

public class Game implements Serializable {
    private Player user;
    private int playerPositionX;
    private int playerPositionY;

    public Game(Player user, int playerPositionX, int playerPositionY) {
        setUser(user);
        setPlayerPositionX(playerPositionX);
        setPlayerPositionY(playerPositionY);
    }

    public Player getUser() {
        return user;
    }

    public void setUser(Player user) {
        this.user = user;
    }

    public int getPlayerPositionX() {
        return playerPositionX;
    }

    public void setPlayerPositionX(int playerPositionX) {
        this.playerPositionX = playerPositionX;
    }

    public int getPlayerPositionY() {
        return playerPositionY;
    }

    public void setPlayerPositionY(int playerPositionY) {
        this.playerPositionY = playerPositionY;
    }
}
