import java.util.Scanner;

public class Extra4Ex2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter student test score: ");
        Float score = input.nextFloat();

        String grade;

        if (score >= 70.0) {
            grade = "A";
        }
        else if (score >= 60.0) {
            grade = "B";
        }
        else if (score >= 50.0) {
            grade = "C";
        }
        else if (score >= 40.0) {
            grade = "D";
        }
        else {
            grade = "No Award";
        }

        System.out.println("Your student grade is: " + grade);
    }
}
