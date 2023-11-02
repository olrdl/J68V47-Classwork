import java.util.*;
public class Lesson7Ex1 {
    public static void main(String[] args) {
        int option = 0;

        do {
            showMenu();
            option = getOption();
            if (option == 1) {
                option1();
            } else if (option == 2) {
                option2();
            } else if (option == 3) {
                option3();
            } else if (option == 4) {
                System.out.println("Bye!");
            } else {
                System.out.println("This isn't a valid option. Try a number between 1 and 4.");
            }
        }
        while (option != 4);
    }

    public static void showMenu() {
        System.out.println("1. ");
        System.out.println("2. ");
        System.out.println("3. ");
        System.out.println("4. ");
    }

    public static int getOption() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Option:");
        int option = input.nextInt();
        return option;
    }

    public static void option1() {
    }

    public static void option2() {
    }

    public static void option3() {
    }
}
