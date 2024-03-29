public class Lesson8Ex3 {
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

        String newDirection = "After turning onto Elm Street, walk past the grocery store on your right.";

        int position = 4;

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

        String[] newDirectionsWithoutLast = new String[newDirections.length - 1];
        System.arraycopy(newDirections, 0, newDirectionsWithoutLast, 0, newDirections.length - 1);

        System.out.println(" ");

        step = 1;
        for(String direction : newDirectionsWithoutLast) {
            System.out.format("%d. %s %n",step,direction);
            step ++;
        }

    }
}
