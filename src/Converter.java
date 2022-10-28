import java.util.Arrays;
import java.util.Scanner;

public class Converter {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = scan.nextInt();

        System.out.println("Enter an input number system: ");
        int numSystem = scan.nextInt();

        System.out.println("Enter an output number system: ");
        int desNumSystem = scan.nextInt();

    }

    public static int toDecimal(int num, int numSystem) {

        if (numSystem == 10) return num;
        else {
            int decNum = 0;

            String temp = Integer.toString(num);
            int[] decNumArr = new int[temp.length()];
            for (int i = 0; i < temp.length(); i++) {
                decNumArr[i] = temp.charAt(i) - '0';
            }

            

            return decNum;
        }
    }
}
