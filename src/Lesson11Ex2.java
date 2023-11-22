import java.io.*;
public class Lesson11Ex2 {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("output.txt"));
            String line;
            do {
                line = in.readLine();
                System.out.println(line);
            }
            while(line != null);
        }
        catch (IOException e) {
            System.out.println("Error occurred reading from file: " + e.toString());
        }
    }

}
