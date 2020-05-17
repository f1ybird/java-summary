package programtest.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Reverse {

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }

    public static int reverse(int x) {
        int ans = 0;
        while (x != 0) {//123
            int pop = x % 10;//3 2 1
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            ans = ans * 10 + pop;//3 32 321
            x /= 10;//12 1 0
        }
        return ans;
    }
}
