public class Car {
    String make = "";
    String model = "";
    Integer year = 0;
    String vin = "";
    Integer price = 0;
    String colour = "";
    Integer mileage = 0;
    String condition = "";

    public Car(String make, String model, int year, String vin, int price, String colour, int mileage, String condition) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.vin = vin;
        this.price = price;
        this.colour = colour;
        this.mileage = mileage;
        this.condition = condition;
    }
}
