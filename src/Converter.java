import java.util.ArrayList;
import java.util.Scanner;

public class Converter {

    public static void main(String[] args) {

        //Collecting the data we need
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scan.nextInt();

        System.out.print("\nEnter an input number system(2-10): ");
        int inputNumSystem = scan.nextInt();

        System.out.print("\nEnter an output number system(2-10): ");
        int outputNumSystem = scan.nextInt();

        System.out.print("\nEnter a number of character: ");
        int charNum = scan.nextInt();

        System.out.println("\nEnter using characters: ");
        String[] charArr = new String[charNum];
        for (int i = 0; i < charNum; i++) {
            System.out.printf("Char #%s: ", i + 1);
            charArr[i] = scan.nextLine();
        }
        ArrayList<Integer> finalNumArr = new ArrayList<>();

        System.out.printf("\nNum %s(%s) in (%s) numeral system -> %s", num, inputNumSystem, outputNumSystem, fromDecimal(toDecimal(num, inputNumSystem), outputNumSystem, finalNumArr));
    }

    //Converting input number to decimal number system
    public static int toDecimal(int num, int inputNumSystem) {

        if (inputNumSystem == 10) return num;
        else {
            int decNum = 0;

            String temp = Integer.toString(num);
            int[] decNumArr = new int[temp.length()];
            for (int i = 0; i < temp.length(); i++) {
                decNumArr[i] = temp.charAt(i) - '0';
            }

            int count = temp.length() - 1;
            for (int i = 0; i < temp.length(); i++) {
                decNum += decNumArr[i] * Math.pow(inputNumSystem, count);
                count--;
            }

            return decNum;
        }
    }

    //Converting number from decimal to output number system
    public static int fromDecimal(int decNum, int outputNumSystem, ArrayList<Integer> finalNumArr) {

        int finalNum = 0;

        int remain = decNum;
        while (remain > 0) {
            finalNumArr.add(remain % outputNumSystem);
            remain /= outputNumSystem;
        }

        for (int i = finalNumArr.size() - 1; i >= 0; i--) {
            finalNum += finalNumArr.get(i) * Math.pow(10, i);
        }

        return finalNum;
    }

    //Building a final word
    public static String buildWord(int charNum, String[] charArr, ArrayList<Integer> finalNumArr) {

        StringBuffer word = new StringBuffer("");

        for (int i = finalNumArr.size(); i >= 0; i--) {
            word = word.append(charArr[finalNumArr.get(i)]);
        }

        return word.toString();
    }
}
