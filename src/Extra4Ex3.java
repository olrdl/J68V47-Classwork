import java.util.Scanner;

public class Extra4Ex3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number between 1 and 7: ");
        int num = input.nextInt();

        if (num == 1) {
            System.out.println("Monday");
        }
        if (num == 2) {
            System.out.println("Tuesday");
        }
        if (num == 3) {
            System.out.println("Wednesday");
        }
        if (num == 4) {
            System.out.println("Thursday");
        }
        if (num == 5) {
            System.out.println("Friday");
        }
        if (num == 6) {
            System.out.println("Saturday");
        }
        else {
            System.out.println("Sunday");
        }
    }
}
