public class StationNode {
    private String stationName;
    private boolean wasHere;
    private long distance;

    public boolean isWasHere(){
        return wasHere;
    }
    public long getDistance(){
        return distance;
    }
    public String getStationName(){
        return stationName;
    }
    public void setStationName(String stationName){
        this.stationName = stationName;
    }

    public void setWasHere(boolean wasHere){
        this.wasHere = wasHere;
    }
    public void setDistance(long distance) {
        this.distance = distance;
    }
    public String getStringDistance(){
        return Integer.toString((int) this.distance);
    }
    public String getStation(){
        return "Station: " + this.getStationName() + ", Distance to it: " + this.getDistance() + ", Was Here: " + this.isWasHere() + "; ";
    }
}
