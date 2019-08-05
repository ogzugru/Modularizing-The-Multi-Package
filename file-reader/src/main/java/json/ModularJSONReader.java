package json;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import car.ModularCar;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ModularJSONReader {
    private String targetFilePath;

    private static ModularJSONReader ourInstance = new ModularJSONReader();

    public static ModularJSONReader getInstance(String targetFilePath) {

        ourInstance.targetFilePath = targetFilePath;

        System.out.println("file path is " + targetFilePath.toString());

        return ourInstance;
    }

    private ModularJSONReader() {
    }

    private static ModularCar apply(JSONObject x) {
        return new ModularCar((String) x.get("make"),
                ((Number) (x.get("year"))).intValue(), (String) x.get("colour"),
                (String) x.get("model"));
    }

    public List<ModularCar> parseFile() throws IOException, ParseException {

        /* JSON PARSER*/
        JSONParser parser = new JSONParser();

        /* JSON OBJECT IS STORES OBJECTS WHICH HAD BEEN PARSED BY JSON PARSER */
        JSONObject json = (JSONObject) parser.parse(new FileReader(targetFilePath));

        /* GETTING JSON ARRAY FROM JSONOBJECT  */
        JSONArray cars = (JSONArray) json.get("cars");

        System.out.println(cars.size() + " cars are in the json file");

        /* WE WILL CREATE A LIST STORES JSONOBJECTS FROM JSONARRAY */
        List<JSONObject> carList = (List<JSONObject>) cars.stream().collect(Collectors.toList());

        /* WE WILL MAKE LIST<Car> BY ONE BY FROM JSONOBJECT LIST */
        return carList.stream()
                .map(ModularJSONReader::apply).collect(Collectors.toList());
    }

}

