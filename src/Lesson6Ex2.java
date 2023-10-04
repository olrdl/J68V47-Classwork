import java.util.*;
import java.time.LocalTime;
public class Lesson6Ex2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LocalTime currentTime = LocalTime.now();
        int input1;
        do {
            System.out.println("1. Say 'Hello' ");
            System.out.println("2. Tell me the time");
            System.out.println("3. Tell me a joke");
            System.out.println("4. Quit");
            input1 = input.nextInt();

            if (input1 == 1) {
                System.out.println("Hello");
            }
            else if (input1 == 2) {
                System.out.println("Sure, here is the time!");
                System.out.println(currentTime);
            }
            else if (input1 == 3) {
                System.out.println("Sure, here is a joke!");
                System.out.println("What do you call a bear with no teeth? A Gummy bear!");
            }
        }
        while (input1 != 4);



    }
}
