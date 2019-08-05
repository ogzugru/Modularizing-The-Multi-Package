package carprocessor;

import car.ModularCar;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ModularCarprocessor {

    public List<ModularCar> carList = null;

    private static ModularCarprocessor ourInstance = new ModularCarprocessor();

    public static ModularCarprocessor getInstance(List<ModularCar> carList) {
        ourInstance.carList = carList;
        return ourInstance;
    }

    private ModularCarprocessor() {
    }

    public List<ModularCar> processList(String filter1, String filter2) {
        return ourInstance.carList.stream().sorted(Comparator.comparing(ModularCar::getYear)).collect(Collectors.toList());
    }


}
