import java.util.LinkedList;

public class MainStation {
    private String stationName;
    private boolean wasHere;
    private LinkedList<StationNode> connections;

    public void setStationName(String stationName){
        this.stationName = stationName;
    }
    public void setConnections(LinkedList<StationNode> connections){
        this.connections = connections;
    }
    public void setWasHere(boolean wasHere){
        this.wasHere = wasHere;
    }
    public void getConsoleStations(){
        System.out.print("Main Station Name: " + this.stationName + "; Was Here: " + this.wasHere + "; \n Connections list: ");
        for (StationNode connection : connections) {
            System.out.print(connection.getStation());
        }
        System.out.print("\n \n");
    }


}
