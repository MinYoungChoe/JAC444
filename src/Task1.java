import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter a credit card number as a long integer: ");
        Long userInputNumber = userInput.nextLong();
        String outPut = (isValid(userInputNumber) ? " is valid" : " is invalid");
        System.out.println(userInputNumber + outPut);

    }
    public static boolean   isValid(long number){

        boolean valid = false;

        if (((getSize(number) >= 13 && getSize(number) <= 16) &&
                (prefixMatched(number, 4) || prefixMatched(number, 5) ||
                        prefixMatched(number, 37) || prefixMatched(number, 6)) &&
                (sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0)) {
            valid = true;
        }

        return valid;
    }
    public static int getSize(long d) {
        String numOfDigits = Long.toString(d);
        return Long.toString(d).length();
    }

    public static int getDigit(int number) {
        if (number < 10){
            return number;
        }
        else {
            return ((number % 10) + (number / 10));
        }
    }

    public static boolean prefixMatched(long number, int d) {
        String num = Long.toString(number);
        int preFixNum = (int) getPrefix(number, d);
        String prefix = Integer.toString(preFixNum);

            if (prefix.length() == 1) {
                //checks first char (position 0) if it matches d
                if (Character.getNumericValue(prefix.charAt(0)) == d) {
                    return true;
                }
            }
            else if (prefix.length() == 2) {
                if (Integer.parseInt(prefix.substring(0,2)) == d) {
                    return true;
                }
            }
        return false;

    }
    public static long getPrefix(long number, int k){
        String numStr = Long.toString(number);
        if (k < 10){
            return k;
        }
        else {
            return Long.parseLong(numStr.substring(0, 2));
        }

    }
    public static int sumOfOddPlace(long number){
        int sum = 0;
        String num = number + "";

        for (int i = getSize(number) - 1; i >= 0; i -= 2){
            sum += Integer.parseInt(num.charAt(i) + "");
        }
        return sum;
    }
    public static int sumOfDoubleEvenPlace(long number){
        int doubleSum = 0;
        String num = number + "";
        for (int i = getSize(number) - 2; i >= 0; i -= 2) {
            doubleSum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);
        }
        return doubleSum;
    }
}