import java.util.*;
public class Lesson4Ex1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Scanner for Inputs
        System.out.print("What is your firstname? ");
        String name = input.nextLine();

        System.out.print("What is your surname? ");
        String surname = input.nextLine();

        Scanner input1 = new Scanner(System.in);
        //New Scanner for inputs
        System.out.print("Enter total value of order: ");
        float orderValue = input1.nextFloat();

        System.out.print("Enter amount you wish to pay as a deposit: ");
        float userDeposit = input1.nextFloat();

        System.out.println("== RECEIPT ==");
        System.out.println("Customer " +  name.substring(0,1).toUpperCase() + surname);
        System.out.println("Order Total " + orderValue);
        System.out.println("Deposit Paid " + userDeposit);
        System.out.println("Remainder " + (orderValue - userDeposit));

        if (userDeposit > 100) {
            System.out.println("You get a free toaster!");
        }
        System.out.println("Have a nice day");







    }
}
