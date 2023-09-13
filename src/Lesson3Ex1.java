import java.util.*;
public class Lesson3Ex1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("What is your firstname? ");
        String firstName = input.nextLine();
        //Gets user`s firstname

        System.out.print("What is your surname? ");
        String surname = input.nextLine();
        //Gets user`s surname

        Scanner input1 = new Scanner(System.in);
        System.out.print("What is your Year of birth? ");
        String year = input1.nextLine();
        //Gets user's Year of birth

        String username = (firstName.substring(0,1)) + surname.toLowerCase(); //1st letter of firstname, Whole surname(lowcase)
        System.out.println("Username:" + username);
        //Creates username and writes to console

        String password = (surname.substring(0,1).toLowerCase()) + (firstName.substring(0,3).toUpperCase()) + year; //1st letter of surname(lowcase), 1st 3 letters of firstname(uppercase) + Year of birth
        System.out.println("Password:" + password);
        //Creates password and writes to console

    }
}
