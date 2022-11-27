import java.util.LinkedList;

public class AdjListMap {
    private LinkedList<MainStation> stations;

    public void setStations(LinkedList<MainStation> stations) {
        this.stations = stations;
    }
    public void getConsoleMap(){
        for (int i = 0; i < stations.size(); i++){
            stations.get(i).getConsoleStations();
        }
    }
}
