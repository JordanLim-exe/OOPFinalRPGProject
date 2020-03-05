package models;

public class Map {
    private String[][] mainMap =
                   {{"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
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
    private int playerPositionX = 9;
    private int playerPositionY = 9;
    private String[][] mapView = new String[][]{
            {mainMap[playerPositionY-2][playerPositionX-2],mainMap[playerPositionY-2][playerPositionX-1],mainMap[playerPositionY-2][playerPositionX],mainMap[playerPositionY-2][playerPositionX+1],mainMap[playerPositionY-2][playerPositionX+2] },
            {mainMap[playerPositionY-1][playerPositionX-2],mainMap[playerPositionY-1][playerPositionX-1],mainMap[playerPositionY-1][playerPositionX],mainMap[playerPositionY-1][playerPositionX+1],mainMap[playerPositionY-1][playerPositionX+2] },
            {mainMap[playerPositionY][playerPositionX-2],mainMap[playerPositionY][playerPositionX-1],mainMap[playerPositionY][playerPositionX],mainMap[playerPositionY][playerPositionX+1],mainMap[playerPositionY][playerPositionX+2]},
            {mainMap[playerPositionY+1][playerPositionX-2],mainMap[playerPositionY+1][playerPositionX-1],mainMap[playerPositionY+1][playerPositionX],mainMap[playerPositionY+1][playerPositionX+1],mainMap[playerPositionY+1][playerPositionX+2]},
            {mainMap[playerPositionY-1][playerPositionX-2],mainMap[playerPositionY-1][playerPositionX-1],mainMap[playerPositionY-1][playerPositionX],mainMap[playerPositionY-1][playerPositionX+1],mainMap[playerPositionY-1][playerPositionX+2] }
    };

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
            playerPositionX++;
        }
        else if(direction.equals("s")){
            playerPositionY++;
        }
        else if(direction.equals("w")){
            playerPositionY--;
        }
        else if(direction.equals("a")){
            playerPositionX--;
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
