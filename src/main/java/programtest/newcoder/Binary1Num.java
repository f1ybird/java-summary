package programtest.newcoder;

import java.util.Scanner;

public class Binary1Num {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        String bNumStr = Integer.toString(num, 2);
        char[] chars = bNumStr.toCharArray();
        int count = 0;
        for (char aChar : chars) {
            if (aChar == 49) {
                count++;
            }
        }
        System.out.println(count);
    }
}
