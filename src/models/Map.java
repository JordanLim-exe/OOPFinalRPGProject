package models;

public class Map {
    private String[][] mainMap;
    private int playerPositionX;
    private int playerPositionY;
    private String[][] mapView;

    public Map() {
        this.playerPositionX = 9;
        this.playerPositionY = 9;
        mainMap = new String[][]{
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "W", "#", "#", "#", "#", "-", "-", "-", "T", "#", "#", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-", "#", "-", "-", "-", "-", "#", "-", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "*", "*", "*", "#", "#", "#", "#", "#", "#", "*", "*", "*", "*", "-", "-", "-"},
                {"-", "-", "-", "*", "*", "*", "*", "*", "*", "*", "*", "#", "*", "*", "*", "*", "-", "-", "-"},
                {"-", "-", "-", "*", "*", "*", "*", "*", "*", "*", "*", "#", "*", "*", "*", "*", "-", "-", "-"},
                {"-", "-", "-", "*", "*", "*", "~", "~", "~", "~", "~", "W", "~", "*", "*", "*", "-", "-", "-"},
                {"-", "-", "-", "*", "*", "*", "~", "~", "~", "~", "~", "#", "~", "*", "*", "*", "-", "-", "-"},
                {"-", "-", "-", "*", "*", "*", "~", "~", "~", "~", "~", "#", "~", "*", "*", "*", "-", "-", "-"},
                {"-", "-", "-", "*", "*", "*", "~", "~", "~", "@", "#", "#", "~", "*", "*", "*", "-", "-", "-"},
                {"-", "-", "-", "*", "*", "*", "~", "~", "~", "#", "~", "~", "~", "*", "*", "*", "-", "-", "-"},
                {"-", "-", "-", "*", "*", "*", "~", "~", "~", "#", "~", "~", "~", "*", "*", "*", "-", "-", "-"},
                {"-", "-", "-", "*", "W", "#", "#", "#", "#", "#", "~", "~", "~", "*", "*", "*", "-", "-", "-"},
                {"-", "-", "-", "*", "*", "*", "*", "*", "*", "#", "*", "*", "*", "*", "*", "*", "-", "-", "-"},
                {"-", "-", "-", "*", "*", "*", "*", "*", "*", "#", "#", "T", "*", "*", "*", "*", "-", "-", "-"},
                {"-", "-", "-", "*", "*", "*", "*", "*", "*", "#", "*", "*", "*", "*", "*", "*", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "#", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "#", "#", "#", "#", "#", "#", "#", "#", "D", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "W", "#", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
        };
        mapView= new String[5][5];
        alterMapView();
    }

    public String[][] getMainMap() {
        return mainMap;
    }

    public String[][] getMapView() {
        return mapView;
    }

    public int getPlayerPositionX() {
        return playerPositionX;
    }

    public int getPlayerPositionY() {
        return playerPositionY;
    }

    public void setPlayerPositionX(int playerPositionX) {
        this.playerPositionX = playerPositionX;
    }

    public void setPlayerPositionY(int playerPositionY) {
        this.playerPositionY = playerPositionY;
    }

    public String movePlayer(String direction){
        if(direction.equals("d")){
            if(playerPositionX < 18) {
                playerPositionX++;
            } else{
                System.out.println("You have hit the boundary");
            }
        }
        else if(direction.equals("s")){
            if(playerPositionY < 18) {
                playerPositionY++;
            } else{
                System.out.println("You have hit the boundary");
            }
        }
        else if(direction.equals("w")){
            if(playerPositionY > 0) {
                playerPositionY--;
            } else{
                System.out.println("You have hit the boundary");
            }
        }
        else if(direction.equals("a")){
            if(playerPositionX > 0) {
                playerPositionX--;
            } else{
                System.out.println("You have hit the boundary");
            }
        }
        alterMapView();
        return mainMap[playerPositionY][playerPositionX];
    }

    public void alterMapView(){
int mapX = 0;
int mapY = 0;
        for (int i = -2; i < 3; i++) {
            mapX=0;
            for (int j = -2; j < 3; j++) {
                try {
                    mapView[mapY][mapX] = mainMap[playerPositionY - i][playerPositionX - j];
                }catch(ArrayIndexOutOfBoundsException ai){
                    mapView[mapY][mapX] = "X";
                }
                mapX++;
            }
            mapY++;
        }
    }
}
