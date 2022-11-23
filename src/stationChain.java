public class stationChain {
    private boolean wasHere;
    private int distance;

    public boolean isWasHere(){
        return wasHere;
    }
    public int getDistance(){
        return distance;
    }

    public void setWasHere(boolean wasHere){
        this.wasHere = wasHere;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
    public String getStringDistance(){
        return Integer.toString(this.distance);
    }
}
