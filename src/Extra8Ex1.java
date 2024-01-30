import java.util.Scanner;

public class Extra8Ex1 {
    public static void main(String[] args) {
        String[] names = new String[5];

        Scanner input = new Scanner(System.in);
        String name;

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter Student name:");
            name = input.nextLine();
            names[i] = name;
        }

        System.out.println(names[0]);
        System.out.println(names[4]);
        System.out.println("The number of items in the array is: " + names.length);
    }
}
