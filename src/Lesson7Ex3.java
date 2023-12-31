import java.util.*;
public class Lesson7Ex3 {
    public static void main(String[] args)
    {
        int score = 0;
        int lives = 3;
        int userAnswer = 0;
        int answer = 1;
        int count = 1;

        while (count <= 10 && lives > 0)
        {
            userAnswer = askQuestion(count,count*count);
            answer = count + (count*count);
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

    public static int askQuestion(int number1, int number2) {
        Scanner input = new Scanner(System.in);
        System.out.print("What is " + number1 + " + " + number2 + "?");
        int userAnswer = input.nextInt();
        return userAnswer;
    }
    public static int correctAnswer(int score) {
        System.out.println("Correct!");
        score = score + 1;
        return score;
    }

    public static int wrongAnswer(int answer, int lives) {
        System.out.println("Wrong! The answer is " + answer);
        lives = lives - 1;
        System.out.println("You have " + lives + "lives left.");
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
