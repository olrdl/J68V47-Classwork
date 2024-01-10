import java.io.BufferedReader;
import java.io.FileReader;

public class Lesson12Ex4 {
    public static void main(String[] args) {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("src/carSales.txt"));
        } catch (Exception e) {
            System.out.println("Error reading file.");
        }

            String line = null;

            try {
                line = reader.readLine();
            }
            catch (Exception e) {
                System.out.println("Error reading line from file.");
            }
    }
}
