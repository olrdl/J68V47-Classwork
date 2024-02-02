import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Extra11Ex3 {
    public static void main(String[] args) {
        ArrayList<String> question = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<>();

        try {
            BufferedReader in = new BufferedReader(new FileReader("src/quiz.txt"));
            String line;

            while ((line = in.readLine()) != null) {
                question.add(line);

                if ((line = in.readLine()) != null) {
                    answer.add(line);
                }
            }
        }
        catch (IOException e) {
            System.out.println("Error occurred reading from file: " + e.toString());
        }

        Scanner input = new Scanner(System.in);
        for (int i = 0; i < question.size(); i++) {
            System.out.println(question.get(i));
            String userAnswer = input.nextLine();

            if (userAnswer.equalsIgnoreCase(answer.get(i))) {
                System.out.println("Correct!");
            }
            else {
                System.out.println("Incorrect.");
            }
        }
    }
}
