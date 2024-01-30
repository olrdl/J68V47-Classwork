import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Extra11Ex1 {
    public static void main(String[] args) {

        int total = 0;
        int lines = 0;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter file name to read from: ");
        String filename = input.nextLine();

        try {
            BufferedReader in = new BufferedReader(new FileReader("src/" + filename));
            String line;
            do {
                line = in.readLine();
                if (line != null) {
                    total = Integer.parseInt(line) + total;
                    lines++;
                }
            }
            while(line != null);
        }
        catch (IOException e) {
            System.out.println("Error occurred reading from file: " + e.toString());
        }

        float average = total / lines;
        System.out.println("The average of all integers in the file is: " + average);
    }
}
