import java.util.LinkedList;

public class MainStation {
    private String stationName;
    private boolean wasHere;
    private LinkedList<StationChain> connections;

    public void setStationName(String stationName){
        this.stationName = stationName;
    }
    public void setConnections(LinkedList<StationChain> connections){
        this.connections = connections;
    }
    public void setWasHere(boolean wasHere){
        this.wasHere = wasHere;
    }
    public void getConsoleStations(){
        System.out.print("Main Station Name: " + this.stationName + "; Was Here: " + this.wasHere + "; \n Connections list: ");
        for (int i = 0; i < connections.size(); i++){
            System.out.print(connections.get(i).getStation());
        }
        System.out.print("\n \n");
    }


}
