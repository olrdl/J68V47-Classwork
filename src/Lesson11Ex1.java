import java.io.*;
import java.util.*;
public class Lesson11Ex1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Number:");
        int number = input.nextInt();

        try {
            FileWriter out = new FileWriter ("output.txt");
            for (int i = 0; i <= 12; i++)
            {
                out.write(number + " x " + i + " = " + (number * i)+ "\n");
            }
            out.close();
        } catch (IOException e) {
            System.out.println("Error occurred writing to file: " + e.toString());
        }

    }

}
