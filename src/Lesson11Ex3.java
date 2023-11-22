import java.io.*;
public class Lesson11Ex3 {
    public static void main(String[] args) {
        int total = 0;
        try {
            BufferedReader in = new BufferedReader( new FileReader("integer.txt"));
            String line = in.readLine();
            while(line != null) {
                int integer = Integer.parseInt(line);
                line = in.readLine();
                total = integer + total;
            }
        }
        catch (IOException e) {
            System.out.println("Error occurred reading from file: " + e.toString());
        }
        catch (NumberFormatException e) {
            System.out.println("The total of integers in the text file: " + total);
        }
    }
}