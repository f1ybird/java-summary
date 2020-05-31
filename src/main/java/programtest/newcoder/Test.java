package programtest.newcoder;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = "";
        while (input.hasNext()) {
            str = input.nextLine();
            int max = 1;
            char[] xx = str.toCharArray();
            int len = xx.length;
            if (len == 0) {
                System.out.println(0);
            } else {
                for (int i = 1; i < len - max / 2; i++) {
                    int low = i - 1;
                    int high = i;
                    while (low >= 0 && high < len && xx[low] == xx[high]) {
                        low--;
                        high++;
                    }
                    if (high - low - 1 > max) {
                        max = high - low - 1;
                    }
                    low = i - 1;
                    high = i + 1;
                    while (low >= 0 && high < len && xx[low] == xx[high]) {
                        low--;
                        high++;
                    }
                    if (high - low - 1 > max) {
                        max = high - low - 1;
                    }
                }
                System.out.println(max);
            }
        }
    }
}
