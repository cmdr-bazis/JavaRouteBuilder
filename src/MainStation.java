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


}
