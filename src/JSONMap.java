import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

public class JSONMap {
    public void setJSON(StationChain[][] map) throws IOException {
        JSONObject JSONmap = new JSONObject();
        GraphMap GraphMap = new GraphMap();
        JSONArray stations = new JSONArray();

        for (int i = 0; i < GraphMap.getStationAmount(); i++){
            JSONObject JSONLineObject = new JSONObject(); //создание объекта для заглавной станции

            JSONLineObject.put("mainStationName",GraphMap.getStationNames(i)); //добавление полей в этот объект
            JSONLineObject.put("mainStationWasHere", map[i][0].isWasHere());

            JSONArray connections = new JSONArray(); //создание вектора для хранения списка станций, в которые можно переместиться с заглавной
            for (int j = 0; i < GraphMap.getStationAmount(); j++){
                if (map[i][j].getDistance() > 0){
                    JSONObject JSONStationObject = new JSONObject(); //создание обекта станции, на которую можно переместиться с заглавной
                    JSONStationObject.put("stationName",GraphMap.getStationNames(j)); //добавление полей в этот объект
                    JSONStationObject.put("distance", map[i][j].getDistance());
                    JSONStationObject.put("wasHere", map[i][j].isWasHere());
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
    private static Object readJsonSimple() throws Exception {
        FileReader reader = new FileReader("JSONMap.json");
        JSONParser jsonParser = new JSONParser();
        return jsonParser.parse(reader);
    }
    public AdjListMap parseJSON() throws Exception {
        GraphMap GraphMap = new GraphMap();

        JSONObject JSONMapFileObject = (JSONObject) readJsonSimple();
        AdjListMap AdjListMap = new AdjListMap();

        JSONArray JSONMainStationsArray = (JSONArray) JSONMapFileObject.get("stations");
        LinkedList<MainStation> mainStations = new LinkedList<>();
        for (int i = 0; i < JSONMainStationsArray.size(); i++){
            MainStation MainStation = new MainStation();
            JSONObject JSONMainStationObject = (JSONObject) JSONMainStationsArray.get(i);

            MainStation.setStationName((String) JSONMainStationObject.get("mainStationName"));
            MainStation.setWasHere((Boolean) JSONMainStationObject.get("mainStationWasHere"));

            JSONArray JSONStationChainArray = (JSONArray) JSONMainStationObject.get("connections");
            LinkedList<StationChain> stations = new LinkedList<>();
            for (int j = 0; j < JSONStationChainArray.size(); j++){
                JSONObject JSONStationObject = (JSONObject) JSONStationChainArray.get(j);
                StationChain StationChain = new StationChain();

                StationChain.setDistance((long) JSONStationObject.get("distance"));
                StationChain.setStationName((String) JSONStationObject.get("stationName"));
                StationChain.setWasHere((boolean) JSONStationObject.get("wasHere"));

                stations.add(StationChain);
            }
            MainStation.setConnections(stations);
            mainStations.add(MainStation);
        }
        AdjListMap.setStations(mainStations);

        return AdjListMap;
    }

}
