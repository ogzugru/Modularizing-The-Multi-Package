package runner;

import car.ModularCar;
import carprocessor.ModularCarprocessor;
import json.ModularJSONReader;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class ApplicationRunner {

    public static void main(String args[]) throws IOException, ParseException {

        String mainPath = ApplicationRunner.class.getName().replace(".", "/") + ".class";
        URL file_path = ApplicationRunner.class.getClassLoader().getResource("cars.json");

        System.out.println("Expected cars.json path is " + file_path.getPath().substring(file_path.getPath().indexOf("/bootstrap")));

        List<ModularCar> carList = ModularJSONReader.getInstance(file_path.getPath()).parseFile();

        System.out.println("The 12th car was maked by " + carList.get(12).getMake());

        carList = ModularCarprocessor.getInstance(carList).processList("In parameter", "filter can be written");

        System.out.println("The 12th car was maked by " + carList.get(12).getMake());

        System.out.println(carList.get(carList.size() - 1).toString() +
                " is the newest car of the town");

        carList.stream().limit(1).forEach(x -> System.out.println("The oldest car is "
                + x.toString()));


    }

}
