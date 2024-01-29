import java.util.Random;
import java.util.Scanner;

public class Extra5Ex2 {
    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt(100);

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter guess from 1-100: ");
            int guess = input.nextInt();

            if (guess == number) {
                break;
            }
        }
        System.out.println("Generated number was: " + number);
    }
}

