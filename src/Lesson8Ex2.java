public class Lesson8Ex2 {
    public static void main(String[] args) {
        int[] scores = {90, 85, 78, 92, 88, 76, 95, 89, 82, 91};
        float total = 0;
        for (int i = 0; i < 10; i++)
        {
            System.out.println(scores[i]);
            total += scores[i];
        }
        float average = total / 10;
        System.out.println("The average score is: " + average);
    }
}