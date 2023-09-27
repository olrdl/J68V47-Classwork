import java.util.Scanner;
public class Lesson5Ex1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter base number for the times table: ");
        float number = input.nextFloat();
        //Scans for users input

        for (int count = 1; count <= 12; count++) {
            //Code to be repeated
            System.out.println(number + " X " + count + " = " + (count * number)); //Prints calculation and answer
        }
    }
}
