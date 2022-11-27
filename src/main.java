import java.io.*;

public class main  {
    public static void main(String[] args) throws Exception {
        BufferedReader mapObj = new BufferedReader(new FileReader("txtMap.txt"));
        GraphMap GraphMap = new GraphMap();
        GraphMap.setMap(mapObj);
        GraphMap.getConsoleMap();
        JSONMap JSONMap = new JSONMap();
        JSONMap.setJSON(GraphMap.getMap());
        JSONMap.parseJSON().getConsoleMap();
    }
}

