import java.util.*;

public class Lesson2Ex1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Scanner for Inputs
        System.out.print("What is your name? ");
        String name = input.nextLine();
        //Input name
        System.out.print("What is your hobby? ");
        String hobby = input.nextLine();
        //Input hobby

        System.out.print(name + " loves " + hobby + " in their free time. \nThey find it relaxing and satisfying to see their " + hobby + " come to life. \n" +  hobby + " allows " + name + " to express their creative side.");
        //Displays Story using the user`s inputs

    }
}
