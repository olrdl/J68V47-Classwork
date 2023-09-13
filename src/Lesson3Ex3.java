import java.util.*;
public class Lesson3Ex3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Loan Amount: ");
        float loan = input.nextInt();

        System.out.print("Interest rate(APR%): ");
        float interest = input.nextInt();

        System.out.print("Number of years: ");
        float years = input.nextInt();
        float j = (interest/12) * 0.01;
        float n = years * 12;
        float monthlyPayments = loan( j / (1- Math.pow((1+j),-n));

        System.out.println("Monthly Payment for this loan = " + monthlyPayments);
    }

}
