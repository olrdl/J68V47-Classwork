import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.*;
public class Lesson11Ex4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter file name 1:");
        String filename1 = input.nextLine();

        System.out.println("Enter file name 2:");
        String filename2 = input.nextLine();

        BufferedReader reader1 = null;
        BufferedReader reader2 = null;

        try {
            reader1 = new BufferedReader(new FileReader(filename1));
        } catch (Exception e) {
            System.out.println("Error reading file 1.");
        }
        try {
            reader2 = new BufferedReader(new FileReader(filename2));
        } catch (Exception e) {
            System.out.println("Error reading file 2.");
        }

        String line1 = null;
        String line2 = null;

        try {
            line1 = reader1.readLine();
        }
        catch (Exception e) {
            System.out.println("Error reading line from file 1");

        }
        try {
            line2 = reader2.readLine();
        }
        catch (Exception e) {
            System.out.println("Error reading line from file 2");
        }
            if (line1 != null && line1.equals(line2)) {
                System.out.print("Files are Identical");
            } else {
                System.out.println("Files are not Identical");
            }
            try {
                reader1.close();
            } catch (Exception e) {
                System.out.println("Error closing file 1.");
            }
            try {
                reader2.close();
            } catch (Exception e) {
                System.out.println("Error reading file 2.");
            }
    }
}
