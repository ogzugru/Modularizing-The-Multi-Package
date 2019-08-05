package car;

public class ModularCar {
/*  "make":"Isuzu",
    "year":1993,
    "colour":"Goldenrod",
    "model":"Amigo"*/

    private final String make;
    private final int year;
    private final String colour;
    private final String model;

    public ModularCar(String make, int year, String colour, String model) {
        this.make = make;
        this.year = year;
        this.colour = colour;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

    public String getColour() {
        return colour;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "" + colour +
                " " + make +
                " " + year + " " + model
                ;
    }

    public String toCSVString() {
        return make + "," + year + "," + colour + "," + model;
    }


}