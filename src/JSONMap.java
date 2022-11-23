import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONMap {
    public void setJSON(stationChain[][] map) throws IOException {
        JSONObject JSONmap = new JSONObject();
        GraphMap GraphMap = new GraphMap();
        JSONArray stations = new JSONArray();

        for (int i = 0; i < GraphMap.getStationAmount(); i++){
            JSONObject JSONLineObject = new JSONObject(); //создание объекта для заглавной станции

            JSONLineObject.put("stationName",GraphMap.getStationNames(i)); //добавление полей в этот объект
            JSONLineObject.put("isWasHere", map[i][0].isWasHere());

            JSONArray connections = new JSONArray(); //создание вектора для хранения списка станций, в которые можно переместиться с заглавной
            for (int j = 0; i < GraphMap.getStationAmount(); j++){
                if (map[i][j].getDistance() > 0){
                    JSONObject JSONStationObject = new JSONObject(); //создание обекта станции, на которую можно переместиться с заглавной
                    JSONStationObject.put("stationName",GraphMap.getStationNames(j)); //добавление полей в этот объект
                    JSONStationObject.put("distance", map[i][j].getDistance());
                    JSONStationObject.put("isWasHere", map[i][j].isWasHere());
                    connections.add(JSONStationObject); //добавление заполненного объекта в вектор станций
                }
                if (j == 11) break;
            }
            JSONLineObject.put("connections", connections ); //добавление заполненного вектора в поле заглавной станции
            stations.add(JSONLineObject); //добавление заполенного объекта заглавной станции в вектор всех станций
            if (i == 11) break;
        }
        JSONmap.put("stations", stations); //добавление вектора всех станций в поле общего объекта
        Files.write(Paths.get("JSONMap.json"), JSONmap.toString().getBytes());
    }
}
