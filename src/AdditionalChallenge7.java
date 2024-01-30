import java.util.Scanner;
public class AdditionalChallenge7 {
    public static void main(String[] args) {
        //Basic Calculator Program
        Scanner input = new Scanner(System.in);

        String operator;
        String end;
        float num1;
        float num2;
        float answer = 0.0F;

        System.out.println("Welcome to the Calculator Program.");
        do {
            System.out.println("Enter number: ");
            num1 = input.nextFloat();

            input.nextLine();

            System.out.println("Enter Function (+, -, *, /): ");
            operator = input.nextLine();

            System.out.println("Enter number: ");
            num2 = input.nextFloat();

            input.nextLine();

            System.out.println("Enter '=' to Finish Calculation: ");
            end = input.nextLine();

        } while (!end.equals("="));

        if (operator.equals("+")) {
            answer = num1 + num2;
        }
        else if (operator.equals("-")) {
            answer = num1 - num2;
        }
        else if (operator.equals("*")) {
            answer = num1 * num2;
        }
        else if (operator.equals("/")) {
            answer = num1 / num2;
        }
        else {
            System.out.println("Invalid Function.");
        }

        System.out.println(num1 + " " + operator + " " + num2 + " = " + answer);
    }
}
