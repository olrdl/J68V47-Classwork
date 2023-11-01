public class Lesson7Ex1 {
    public static void main(String[] args) {
        int option = 0;

        do
        {
            showMenu();
            option = getOption(option);
            if option == 1
            {
                option1();
            }
            else if option == 2
            {
                option2();
            }
            else if option == 3
            {
                option3();
            }
            else if option == 4
            {
                System.out.println("Bye!");
            }
            else
            {
                System.out.println("This isn't a valid option. Try a number between 1 and 4.")
            }

        }
        while option != 4;
    }
}
