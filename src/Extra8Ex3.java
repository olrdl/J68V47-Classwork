import java.util.*;
public class Extra8Ex3 {
    public static void main(String[] args) {
        // Set up the directions array
        String[] directions = {"Start by exiting the building you are currently in and turning left onto the main road.",
                "Walk down the road for two blocks until you reach the traffic lights.",
                "At the traffic lights, turn right onto Oak Street.",
                "Follow Oak Street for one block then turn left onto Elm Street.",
                "Walk to the end of Elm Street. Your doctor's office will be the third building on the right side of the road.",
                "Enter through the front door of the office. Let the receptionist know you have arrived for your appointment.",
                "Take a seat in the waiting room. The doctor will call your name when it's time to be seen. You've arrived!"
        };

        // Print out each direction
        int step = 1;
        for(String direction : directions) {
            System.out.format("%d. %s %n",step,direction);
            step ++;
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Enter new direction to add to array: ");
        String newDirection = input.nextLine();

        System.out.println("Enter position to insert into array:  ");
        int position = input.nextInt();

        String[] newDirections = new String[directions.length + 1];
        System.arraycopy(directions, 0, newDirections, 0, directions.length);
        System.arraycopy(newDirections, position, newDirections, position + 1, newDirections.length - position - 1);
        newDirections[position] = newDirection;

        System.out.println(" ");

        step = 1;
        for(String direction : newDirections) {
            System.out.format("%d. %s %n",step,direction);
            step ++;
        }
    }
}
