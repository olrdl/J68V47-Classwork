import java.util.*;
public class Lesson3Ex2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Q1. What is the capital of Spain?");
        String answer1 = input.nextLine();                       //Gets Input for Q1
        System.out.print("Q2. What is the capital of UK?");
        String answer2 = input.nextLine();                       //Gets Input for Q2
        System.out.print("Q3. What is the capital of Italy?");
        String answer3 = input.nextLine();                       //Gets Input for Q3

        answer1 = answer1.toUpperCase(); //Capitalises Input for answer1
        answer2 = answer2.toUpperCase(); //Capitalises Input for answer2
        answer3 = answer3.toUpperCase(); //Capitalises Input for answer3

        System.out.println(answer1.contains("MADRID")); //Checks to see if answer1 is correct/true

        System.out.println(answer2.contains("LONDON")); //Checks to see if answer2 is correct/true

        System.out.println(answer3.contains("ROME")); //Checks to see if answer3 is correct/true


    }
}
