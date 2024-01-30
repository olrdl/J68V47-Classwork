import java.util.*;
public class Extra7Ex2 {
    public static void main(String[] args) {
        int option = 0;

        do {
            showMenu();
            option = getOption();
            if (option == 1) {
                option1();
            } else if (option == 2) {
                option2();
            } else if (option == 3) {
                System.out.println("Bye!");
            } else {
                System.out.println("This isn't a valid option. Try a number between 1 and 4.");
            }
        }
        while (option != 3);
    }

        public static void showMenu() {
        System.out.println("1. Easy math problems");
        System.out.println("2. Hard math problems");
        System.out.println("3. Quit");
    }

        public static int getOption() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Option:");
        int option = input.nextInt();
        return option;
    }

        public static void option1() {
            int score = 0;
            int lives = 3;
            int userAnswer = 0;
            int answer = 1;
            int count = 1;

            Random random = new Random();

            while (count <= 10 && lives > 0)
            {
                int number1 = random.nextInt(100);
                int number2 = random.nextInt(100);

                Scanner input = new Scanner(System.in);
                System.out.print("What is " + number1 + " + " + number2 + "?");
                userAnswer = input.nextInt();

                answer = number1 + number2;
                if (answer == userAnswer)
                {
                    score = correctAnswer(score);
                }
                else
                {
                    lives = wrongAnswer(answer,lives);
                }
                count = count + 1;
            }
            gameOver(score, lives);
    }

        public static void option2() {
            int score = 0;
            int lives = 3;
            int userAnswer = 0;
            int answer = 1;
            int count = 1;

            Random random = new Random();

            while (count <= 10 && lives > 0)
            {
                int number1 = random.nextInt(100);
                int number2 = random.nextInt(100);

                Scanner input = new Scanner(System.in);
                System.out.print("What is " + number1 + " * " + number2 + "?");
                userAnswer = input.nextInt();

                answer = number1 * number2;
                if (answer == userAnswer)
                {
                    score = correctAnswer(score);
                }
                else
                {
                    lives = wrongAnswer(answer,lives);
                }
                count = count + 1;
            }
            gameOver(score, lives);
    }

    public static int correctAnswer(int score) {
        System.out.println("Correct!");
        score = score + 1;
        return score;
    }

    public static int wrongAnswer(int answer, int lives) {
        System.out.println("Wrong! The answer is " + answer);
        lives = lives - 1;
        System.out.println("You have " + lives + " lives left.");
        return lives;
    }

    public static void gameOver(int score, int lives) {
        System.out.println("Game over. Your score is " + score);
        if (lives > 0)
        {
            System.out.println("Well done!");
        }
    }
}
