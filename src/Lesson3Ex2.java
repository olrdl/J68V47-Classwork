import java.util.*;
public class Lesson3Ex2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Q1. What is the capital of Spain?");
        String answer1 = input.nextLine();
        System.out.print("Q2. What is the capital of UK?");
        String answer2 = input.nextLine();
        System.out.print("Q3. What is the capital of Italy?");
        String answer3 = input.nextLine();

        answer1 = answer1.toUpperCase();
        answer2 = answer2.toUpperCase();
        answer3 = answer3.toUpperCase();

        System.out.println(answer1.contains("MADRID")); // true

        System.out.println(answer2.contains("LONDON")); // true

        System.out.println(answer3.contains("ROME")); // true


    }
}
