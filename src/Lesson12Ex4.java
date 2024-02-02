import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
public class Lesson12Ex4 {
    public static void main(String[] args) {
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
        catch (Exception e){
            System.out.println("Error reading from carSales file.");
        }

        for(Car car : carArrayList) {
            System.out.println(car.make + " (" + car.year + ")");
            System.out.println("Vin: " + car.vin);
            System.out.println("Colour: " + car.colour);
            System.out.println("Mileage: " + car.mileage);
            System.out.println("Condition: " + car.condition);
            System.out.println("Price: " + car.price);
            System.out.println("---------------------------------------------");
        }
    }
}
