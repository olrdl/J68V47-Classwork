import java.util.*;
public class Lesson8Ex3 {
    public static void main(String[] args) {
        // Set up the directions array
        String[] oldArray = {"Start by exiting the building you are currently in and turning left onto the main road.",
                "Walk down the road for two blocks until you reach the traffic lights.",
                "At the traffic lights, turn right onto Oak Street.",
                "Follow Oak Street for one block then turn left onto Elm Street.",
                "Walk to the end of Elm Street. Your doctor's office will be the third building on the right side of the road.",
                "Enter through the front door of the office. Let the receptionist know you have arrived for your appointment.",
                "Take a seat in the waiting room. The doctor will call your name when it's time to be seen. You've arrived!"
        };

        String[] newArray = addToStringArray(oldArray, "After turning onto Elm Street, walk past the grocery store on your right.");
        newArray = removeLastElement(newArray);

        // Print out the array
        int step = 1;
        for (String direction : newArray) {
            System.out.format("%d. %s %n", step, direction);
            step++;
        }
    }

    public static String[] addToStringArray(String[] oldArray, String newString) {
        String[] newArray = Arrays.copyOf(oldArray, oldArray.length + 1);
        newArray[oldArray.length] = newString;
        return newArray;
    }


    public static String[] removeLastElement(String[] oldArray) {
        return Arrays.copyOf(oldArray, oldArray.length - 1);
    }

    public static String[] removeElementAt(String[] oldArray, int index) {
        int length = oldArray.length;
        String[] newArray = new String[length - 1]; // Create the new array
        // Copy old values before the index to remove
        System.arraycopy(oldArray, 0, newArray, 0, index);
        if (index < (length - 1)) {
            // Copy old values after the index to remove
            System.arraycopy(oldArray, index + 1, newArray, index, length - index - 1);
        }
        return newArray;
    }
}