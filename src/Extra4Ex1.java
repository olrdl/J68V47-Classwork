import java.util.Random;
import java.util.Scanner;

public class Extra4Ex1 {
    public static void main(String[] args) {
        int lives = 3;

        Random random = new Random();
        int number = random.nextInt(100);

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number to guess from 1-100: ");
        int guess = input.nextInt();
        lives--;

        do {
            if (guess < number) {
                System.out.println("Higher!");
                lives--;
                System.out.print("Enter number to guess: ");
                guess = input.nextInt();
            }
            else if (guess > number) {
                System.out.println("Lower!");
                lives--;
                System.out.print("Enter number to guess: ");
                guess = input.nextInt();
            }

            else {
                System.out.print("Correct!");
                break;
            }

        } while (guess != number && lives > 0);
    }
}
