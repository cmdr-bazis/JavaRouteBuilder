import java.io.BufferedReader;
import java.io.IOException;

public class GraphMap {
    private int stationAmount = 12;
    private stationChain[][] map = new stationChain[stationAmount][stationAmount];

    protected String[] stationNames = {"A" , "B" , "C" , "D" , "E" , "F" , "G" , "H" , "I" , "J" , "K" , "L" , "M" , "N" , "O" , "P" , "Q" , "R" , "S" , "T" , "U" , "V" , "W" , "X" , "Y" , "Z"};
    public void setMap(BufferedReader mapObj) throws IOException {
        String tempLine = " ";
        String[] tempLineArray = new String[12];

        for (int i = 0; i < stationAmount; i++){
            tempLine = mapObj.readLine();
            tempLineArray = tempLine.split(" ");
            for (int j = 0; j < stationAmount; j++) {

                map[i][j] = new stationChain();
                map[j][i] = new stationChain();

                if (tempLineArray[j].equals(".")) {
                    map[i][j].setDistance(-1);
                }
                else if (tempLineArray[j].equals("0")) {
                    map[i][j].setDistance(0);
                }
                else {
                    Integer convertedDistance = Integer.valueOf(tempLineArray[j]);
                    map[i][j].setDistance(convertedDistance);
                    map[j][i].setDistance(convertedDistance);
                }
            }
        }
    }
    public void getStringMap(){
        for (int i = 0; i < stationAmount; i++){
            System.out.println("\n");
            for (int j = 0; j < stationAmount; j++){
                System.out.print(map[i][j].getDistance() + " ");
            }
        }
    }
    public stationChain[][] getMap(){
        return map;
    }

    public String getStationNames(int stationNumber) {
        return stationNames[stationNumber];
    }
    public int getStationAmount(){
        return stationAmount;
    }
}