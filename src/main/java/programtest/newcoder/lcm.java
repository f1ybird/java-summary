package programtest.newcoder;

import java.util.Scanner;

public class lcm {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y = input.nextInt();
        int gcd = getGcd(x, y);
        int lcm = (x * y) / gcd;
        System.out.println("x=" + x + ",y=" + y + "的" + "最大公约数：" + gcd + ",最小公倍数：" + lcm);
    }

    /**
     * 最大公约数
     *
     * @param x
     * @param y
     * @return
     */
    private static int getGcd(int x, int y) {
        if (x < y) {
            x ^= y;
            y ^= x;
            x ^= y;
        }
        int r = x % y;
        while (r != 0) {
            x = y;
            y = r;
            r = x % y;
        }
        return y;
    }
}
