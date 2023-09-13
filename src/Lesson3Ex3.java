import java.util.*;
public class Lesson3Ex3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Loan Amount: ");
        float loan = input.nextFloat();

        System.out.print("Interest rate(APR%): ");
        float interest = input.nextFloat();

        System.out.print("Number of years: ");
        float years = input.nextInt();
        float j = ((float)interest/12)/100;
        float n = years * 12;
        float monthlyPayments = (float)(loan*( j / (1- Math.pow((1+j),-n))));
        //System.out.format("%f %f %f",j, n, monthlyPayments);

        System.out.println("Monthly Payment for this loan = " + monthlyPayments);
    }

}
