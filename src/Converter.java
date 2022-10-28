import java.util.ArrayList;
import java.util.Scanner;

public class Converter {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = scan.nextInt();

        System.out.println("Enter an input number system(2-10): ");
        int numSystem = scan.nextInt();

        System.out.println("Enter an output number system(2-10): ");
        int finalNumSystem = scan.nextInt();

        System.out.println(fromDecimal(toDecimal(num, numSystem), finalNumSystem));

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

            int count = temp.length() - 1;
            for (int i = 0; i < temp.length(); i++) {
                decNum += decNumArr[i] * Math.pow(numSystem, count);
                count--;
            }

            return decNum;
        }
    }

    public static int fromDecimal(int decNum, int finalNumSystem) {

        int finalNum = 0;
        ArrayList<Integer> finalNumArr = new ArrayList<>();
        int remain = decNum;
        while (remain > 0) {
            finalNumArr.add(remain % finalNumSystem);
            remain /= finalNumSystem;
        }

        for (int i = finalNumArr.size() - 1; i >= 0; i--) {
            finalNum += finalNumArr.get(i) * Math.pow(10, i);
        }

        return finalNum;
    }
}
