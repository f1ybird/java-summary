package programtest.newcoder;

import java.util.Scanner;

public class CountCharNum {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next().toLowerCase();
        char c = s.next().toLowerCase().charAt(0);
        int i = getCount(str, c);
        System.out.println(i);
    }

    public static int getCount(String s, char c) {
        int count = 0;
        if (null != s && s.length() > 0) {
            for (int i = 0; i < s.length(); i++) {
                if (c == s.charAt(i)) {
                    count++;
                }
            }
        } else {
            count = 0;
        }
        return count;
    }
}