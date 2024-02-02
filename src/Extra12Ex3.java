import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Extra12Ex3 {
    public static void main(String[] args) {
        Boolean foundCar = false;
        ArrayList<Car> carArrayList = new ArrayList<>();

        try {
            BufferedReader in = new BufferedReader(new FileReader("src/carSales.txt"));
            String line = in.readLine();
            while (line != null) {
                String[] carDetails = line.split(",");

                String make = carDetails[0];
                String model = carDetails[1];
                int year = Integer.parseInt(carDetails[2]);
                String vin = carDetails[3];
                int price = Integer.parseInt(carDetails[4]);
                String colour = carDetails[5];
                int mileage = Integer.parseInt(carDetails[6]);
                String condition = carDetails[7];

                Car car = new Car(make, model, year, vin, price, colour, mileage, condition);
                carArrayList.add(car);

                line = in.readLine();
            }
        }
        catch (Exception e) {
            System.out.println("Error reading from carSales file.");
        }

        Scanner input = new Scanner(System.in);

        System.out.println("Enter Maximum Mileage: ");
        int maxMileage = input.nextInt();

        try {
            FileWriter out = new FileWriter("src/searchResults.txt", true);

            for (Car car : carArrayList) {
                if (car.mileage <= maxMileage) {
                    foundCar = true;

                    out.write(car.make + " (" + car.year + ")" + "\n");
                    out.write("Vin: " + car.vin + "\n");
                    out.write("Colour: " + car.colour + "\n");
                    out.write("Mileage: " + car.mileage + "\n");
                    out.write("Condition: " + car.condition + "\n");
                    out.write("Price: " + car.price + "\n");
                    out.write("---------------------------------------------" + "\n");
                }
            }

            out.close();
        } catch (Exception e) {
            System.out.println("Error writing to searchResults file." + "\n");
        }

        if (!foundCar) {
            System.out.println("No results found.");
        }
    }
}
