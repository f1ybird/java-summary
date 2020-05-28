package programtest.newcoder;

import java.util.Scanner;

public class RadixConver {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String hexStr = input.next().substring(2);
        System.out.println(String.valueOf(Integer.parseInt(hexStr, 16)));
    }
}