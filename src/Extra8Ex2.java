public class Extra8Ex2 {
    public static void main(String[] args) {
        int[] scores = {90, 85, 78, 92, 88, 76, 95, 89, 82, 91};
        int max = scores[0];
        int min = scores[0];

        float total = 0;

        for (int i = 0; i < 10; i++)
        {
            if (scores[i] < min) {
                min = scores[i];
            }

            if (scores[i] > max) {
                max = scores[i];
            }

            System.out.println(scores[i]);
            total += scores[i];
        }

        float average = total / 10;
        System.out.println("The maximum score is: " + max);
        System.out.println("The minimum score is: " + min);
        System.out.println("The average score is: " + average);
    }
}
