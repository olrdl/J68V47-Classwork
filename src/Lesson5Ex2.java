public class Lesson5Ex2 {
    public static void main(String[] args) {

        for( int count=10; count>=1; count-=1 ) //Fixed loop for countdown
        {
            //Code to be repeated
            System.out.println(count);
            if (count <=1) { //Checks if condition is met
                System.out.println("BLASTOFF!!!"); //Prints message
            }
        }


    }
}
