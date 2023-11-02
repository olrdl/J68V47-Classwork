import java.util.*;
 public class Lesson7Ex2 {
     public static void main(String[] args) {

         Scanner input1 = new Scanner(System.in);
         System.out.print("Enter the first number:");
         int number1 = input1.nextInt();

         Scanner input2 = new Scanner(System.in);
         System.out.print("Enter the second number:");
         int number2 = input2.nextInt();

         int answer = calculateSum(number1, number2);

         System.out.println("The sum of " + number1 + " and " + number2 + " is " + answer);
     }

     public static int calculateSum(int number1, int number2) {
         int answer = number1 + number2;
         return answer;
     }
}
