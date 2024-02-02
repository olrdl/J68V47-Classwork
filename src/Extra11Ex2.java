import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Extra11Ex2 {
    public static void main(String[] args) {
        List<String> Runners = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/runners.txt"));
            String line = in.readLine();

            while (line != null) {
                Runners.add(line);
                line = in.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error occurred reading from file: " + e.toString());
        }

        Runners.sort((s1, s2) -> {
            String[] time1 = s1.split(", ");
            String[] time2 = s2.split(", ");
            return Float.compare(Float.parseFloat(time1[1]), Float.parseFloat(time2[1]));
        });

        try {
            FileWriter out = new FileWriter("src/fastestRun.txt");
            out.write("The fastest runner is: " + Runners.get(0));
            out.close();
        } catch (IOException e) {
            System.out.println("Error occurred writing to file: " + e.toString());
        }
    }
}
