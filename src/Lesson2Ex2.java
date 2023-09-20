import java.util.*;
public class Lesson2Ex2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");  //Gets input for num1
        int num1 = input.nextInt();
        System.out.print("Enter another number(Smaller than first number): "); //Gets input for num2
        int num2 = input.nextInt();

        int add = num1 + num2;   //Performs Calculations
        int sub = num1 - num2;
        int multiply = num1 * num2;
        int div = num1/num2;
        int modulo = num1 % num2;
        double expo = Math.pow(num1, num2);

        System.out.println("Addition:" + add);            //Prints Answers to Calculations
        System.out.println("Subtraction:" + sub);
        System.out.println("Multiplication:" + multiply);
        System.out.println("Division:" + div);
        System.out.println("Modulo:" + modulo);
        System.out.println("Exponent:" + expo);
    }
}
