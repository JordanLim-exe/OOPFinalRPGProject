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
    private String[][] mapView;
    private int playerPositionX = 9;
    private int playerPositionY = 9;

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

    public String movePlayer(String direction){
        if(direction.equals("d")){
            playerPositionX++;
        }
        else if(direction.equals("s")){
            playerPositionY--;
        }
        else if(direction.equals("w")){
            playerPositionY++;
        }
        else if(direction.equals("a")){
            playerPositionX--;
        }
        alterMapView();
        return mainMap[playerPositionY][playerPositionX];
    }

    public void alterMapView(){
        mapView = new String[][]{
                {mainMap[playerPositionY-2][playerPositionX-2],mainMap[playerPositionY-2][playerPositionX-1],mainMap[playerPositionY-2][playerPositionX],mainMap[playerPositionY-2][playerPositionX+1],mainMap[playerPositionY-2][playerPositionX+2] },
                {mainMap[playerPositionY-1][playerPositionX-2],mainMap[playerPositionY-1][playerPositionX-1],mainMap[playerPositionY-1][playerPositionX],mainMap[playerPositionY-1][playerPositionX+1],mainMap[playerPositionY-1][playerPositionX+2] },
                {mainMap[playerPositionY][playerPositionX-2],mainMap[playerPositionY][playerPositionX-1],mainMap[playerPositionY][playerPositionX],mainMap[playerPositionY][playerPositionX+1],mainMap[playerPositionY][playerPositionX+2]},
                {mainMap[playerPositionY+1][playerPositionX-2],mainMap[playerPositionY+1][playerPositionX-1],mainMap[playerPositionY+1][playerPositionX],mainMap[playerPositionY+1][playerPositionX+1],mainMap[playerPositionY+1][playerPositionX+2]},
                {mainMap[playerPositionY-1][playerPositionX-2],mainMap[playerPositionY-1][playerPositionX-1],mainMap[playerPositionY-1][playerPositionX],mainMap[playerPositionY-1][playerPositionX+1],mainMap[playerPositionY-1][playerPositionX+2] }
        };
    }
}
