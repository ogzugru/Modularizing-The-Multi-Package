package runner;

import car.ModularCar;

import java.net.URL;
import java.util.List;

public class ApplicationRunner {

    public static void  main(String args[]) {

        String mainPath = ApplicationRunner.class.getName().replace(".", "/") + ".class";
        URL file_path =ApplicationRunner.class.getClassLoader().getResource("cars.json");

        System.out.println(file_path.toString());

        List<ModularCar> carList;


    }

}
