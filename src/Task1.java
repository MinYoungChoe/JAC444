import java.util.Scanner;
public class Task1 {
    public static void main(String[] args) {
        System.out.println("Enter a credit card number as a long integer: \n");
        Scanner userInput = new Scanner(System.in);

        long testNum = 1;
        System.out.println("size: " +getSize(testNum));

    }
public static int getSize(long d){
        return Long.toString(d).length();
}

}

