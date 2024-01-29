import java.util.Scanner;

public class Extra5Ex3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter character combination to repeat: ");
        String combination = input.nextLine();

        System.out.println("Enter number of times for pattern to repeat: ");
        int repeat = input.nextInt();

        for (int i = 0; i < repeat; i++) {
            System.out.print(combination);
        }
    }

}
