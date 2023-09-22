import java.util.*;
public class Lesson4Ex2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Q1. What is the capital of Spain?");
        String answer1 = input.nextLine();
        //Gets Input for Q1

        if (answer1.toUpperCase().equals("MADRID")) { //Checks if condition is met(if Answer is correct)
            System.out.println("True");
        }
        else {
            System.out.println("Sorry, the correct answer is Madrid"); //Displays error message if Answer is not correct
        }



        System.out.print("Q2. What is the capital of UK?");
        String answer2 = input.nextLine(); //Gets Input for Q2

        if (answer2.toUpperCase().equals("LONDON")) { //Checks if condition is met(if Answer is correct)
            System.out.println("True");
        }
        else {
            System.out.println("Sorry, the correct answer is London"); //Displays error message if Answer is not correct
        }



        System.out.print("Q3. What is the capital of Italy?");
        String answer3 = input.nextLine(); //Gets Input for Q3

        if (answer3.toUpperCase().equals("ROME")) { //Checks if condition is met(if Answer is correct)
            System.out.println("True");
        }
        else {
               System.out.println("Sorry, the correct answer is Rome"); //Displays error message if Answer is not correct
             }







    }
}