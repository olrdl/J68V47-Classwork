import java.util.*;
public class Lesson2Ex3 {
    public static void main(String[] args) {
        Scanner inputName = new Scanner(System.in);
        System.out.print("Enter name of item 1: ");  //Gets name of item 1-3
        String name1 = inputName.nextLine();
        System.out.print("Enter name of item 2: ");
        String name2 = inputName.nextLine();
        System.out.print("Enter name of item 3: ");
        String name3 = inputName.nextLine();

        Scanner inputPrice = new Scanner(System.in);
        System.out.print("Enter price of " + name1 + ": ");  //Gets price of item 1-3
        float price1 = inputPrice.nextFloat();
        System.out.print("Enter price of " + name2 + ": ");
        float price2 = inputPrice.nextFloat();
        System.out.print("Enter price of " + name3 + ": ");
        float price3 = inputPrice.nextFloat();

        float totalCost = price1 + price2 + price3; //Calculates totalCost

        System.out.println("NESMART");                                       //Prints Receipt with names, prices, and totalCost
        System.out.println(name1 + " ..... " + "£" + price1);
        System.out.println(name2 + " ..... " + "£" + price2);
        System.out.println(name3 + " ..... " + "£" + price3);
        System.out.println("SUBTOTAL" + " ..... " + "£" + totalCost);



    }
}



