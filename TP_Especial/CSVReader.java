package progTPE;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static void main(String[] args) {
        String csvFile = "C:/Users/matit/workspace/Prog3-tpe/src/progTPE/Reservas.csv";
        String line = "";
        String cvsSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                String[] items = line.split(cvsSplitBy);
                System.out.println("Name : " + items[0]);
                System.out.println("Email : " + items[1]);
                System.out.println("Phone : " + items[2]);
                System.out.println("Country : " + items[3]);
                System.out.println("==========================");
                // ---------------------------------------------
                // Poner el codigo para cargar los datos
                // ---------------------------------------------

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
