import java.util.*;
public class Lesson4Ex3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your total purchase amount: £"); //Gets total exluding shipping
        float totalAmount = input.nextFloat();

        int shippingCost = 0;

    if (totalAmount < 50.00) { //Calculates shipping costs using condition
        shippingCost = 10;
        }

    System.out.println("Shipping cost is = £" + shippingCost); //Displays Shipping Cost
    System.out.println("Your final total is = £" + (totalAmount + shippingCost)); //Displays Total Cost

    }
}
