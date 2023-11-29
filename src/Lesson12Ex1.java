import java.util.*;
public class Lesson12Ex1 {
    public static void displayStudent(Student thisStudent){
        System.out.format("(%d) %s %s %n",thisStudent.id, thisStudent.firstName, thisStudent.surname);
    }
    public static void main(String[] args) {
        // create student object and display
        Student student1 = new Student();
        displayStudent(student1);
        // update values of student object and display
        Scanner input = new Scanner(System.in);

        System.out.println("Enter ID: ");
        student1.id = input.nextInt();

        Scanner input1 = new Scanner(System.in);

        System.out.println("Enter First Name: ");
        student1.firstName = input1.nextLine();

        System.out.println("Enter Surname: ");
        student1.surname = input1.nextLine();

        displayStudent(student1);

    }
}
