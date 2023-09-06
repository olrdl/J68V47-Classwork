import java.util.*;
public class Lesson2Ex1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("What is your hobby? ");
        String hobby = input.nextLine();

        System.out.print(name + " loves " + hobby + " in their free time. \n They find it relaxing and satisfying to see their " + hobby + " come to life. \n" +  hobby + " allows " + name + " to express their creative side.");


    }
}
