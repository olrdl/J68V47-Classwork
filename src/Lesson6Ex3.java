import java.util.Scanner;
import java.util.*;
public class Lesson6Ex3 {
    public static void main(String[] args) {
        int score = 0;
        int lives = 3;
        int count = 1;
            Scanner input = new Scanner(System.in);
            for (count = 1; count <= 10; count++) { //Creates loop for 10 iterations
                float num1 = (float) Math.floor(Math.random() * 10); //Generates a random number for each iteration
                float num2 = (float) Math.floor(Math.random() * 10); ////Generates another random number for each iteration
                float answer = (float) (num1 * num2);
                System.out.println(num1 + " * " + num2 + " = "); //Prints question for user
                float userAnswer = input.nextInt(); //Gets users input for answer
                if (answer == userAnswer) { //Checks if condition is met (if answer is correct)
                    System.out.println("Correct!"); //Prints message if correct
                    score += 1; //Adds 1 to score for each correct answer
                } else {
                    System.out.println("Incorrect!, the correct answer is " + answer); //Prints error message with correct answer
                    lives -= 1;
                }
                if (lives <= 0){
                    System.out.println("Out of lives.");
                    break; //Breaks fixed loop when user runs out of lives

                }
                System.out.println("Well done!"); //Prints message if user successfully finishes quiz without running out of lives
            }

        System.out.println("Your score is " + score); //Prints final score
    }

}

