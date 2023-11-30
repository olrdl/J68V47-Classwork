public class Lesson12Ex3 {
    public static class Car {
        String Make = "";
        String Model = "";
        Integer Year = 0;
        String Vin = "";
        Integer Price = 0;
        String Colour = "";
        Integer Mileage = 0;
        String Condition = "";
    }
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.Make = "Ferrari";
        car1.Model = "F430";
        car1.Year = 2009;
        car1.Vin = "3GYVKNEFXAG625569";
        car1.Price = 55125;
        car1.Colour = "White";
        car1.Mileage = 45336;
        car1.Condition = "Good";

        System.out.println(car1.Make + " "  + car1.Model + "(" + car1.Year + ")");
        System.out.println("Vin: " + car1.Vin);
        System.out.println("Colour: " + car1.Colour);
        System.out.println("Mileage: " + car1.Mileage);
        System.out.println("Condition: " + car1.Condition);
        System.out.println("Price: " + car1.Price);
    }
}
