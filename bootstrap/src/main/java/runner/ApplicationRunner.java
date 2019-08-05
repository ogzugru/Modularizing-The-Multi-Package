package runner;

import car.ModularCar;
import json.ModularJSONReader;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class ApplicationRunner {

    public static void  main(String args[]) throws IOException, ParseException {

        String mainPath = ApplicationRunner.class.getName().replace(".", "/") + ".class";
        URL file_path =ApplicationRunner.class.getClassLoader().getResource("cars.json");

        System.out.println("Expected cars.json path is " + file_path.getPath().substring(file_path.getPath().indexOf("/bootstrap")));

        List<ModularCar> carList = ModularJSONReader.getInstance(file_path.getPath()).parseFile();

        System.out.println(carList.size());

    }

}
