package CSVWriter;

import car.ModularCar;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.sql.ResultSet;
import java.util.List;

public class CSVWriter {
    private static CSVWriter ourInstance = new CSVWriter();


    private String destinationFilePath_of_CSV;


    public static CSVWriter getInstance(String destinationFilePath_of_CSV) {

        ourInstance.destinationFilePath_of_CSV = destinationFilePath_of_CSV;

        System.out.println("Destination file path of CSV is " + destinationFilePath_of_CSV.toString());

        return ourInstance;
    }

    private CSVWriter() {
    }

    public void write_CSV_process(List<ModularCar> carList_in) throws IOException {

        BufferedWriter writer = Files.newBufferedWriter(Paths.get(destinationFilePath_of_CSV));

        CSVPrinter printer = new CSVPrinter(writer, CSVFormat.MYSQL.withHeader("make,", "year,", "colour,", "model"));


        carList_in.forEach(x -> {
            try {
                printer.printRecords( x.toCSVString() );

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        printer.flush();
        printer.close();

    }


}
