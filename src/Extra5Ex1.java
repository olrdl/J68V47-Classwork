import java.util.Scanner;

public class Extra5Ex1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number to multiply to: ");
        int number = input.nextInt();

        for (int i = 1; i <= number; i++) {
            int result = i * i;
            System.out.println(i + " x " + i + " = " + result);
        }
    }
}
