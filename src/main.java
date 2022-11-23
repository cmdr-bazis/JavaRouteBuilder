import java.io.*;
import java.io.IOException;

public class main  {
    public static void main(String[] args) throws IOException {
        BufferedReader mapObj = new BufferedReader(new FileReader("txtMap.txt"));
        GraphMap GraphMap = new GraphMap();
        GraphMap.setMap(mapObj);
        GraphMap.getStringMap();
        JSONMap JSONMap = new JSONMap();
        JSONMap.setJSON(GraphMap.getMap());
    }
}

