import java.io.*;
import java.util.*;
public class Lesson11Ex4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name of file 1:");
        String file1 = input.nextLine();
        System.out.println("Enter name of file 2:");
        String file2 = input.nextLine();

        try {
            BufferedReader reader1 = new BufferedReader(new FileReader(file1));
            BufferedReader reader2 = new BufferedReader(new FileReader(file2));

            String line1 = reader1.readline();
            String line2 = reader2.readline();

            while (line1 != null && line2 != null)
            {
                if (!line1.equals(line2)) {
                    System.out.println("File not Identical");
                }
                else {
                    System.out.println("File Identical");
            }
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.toString());


    }
}
