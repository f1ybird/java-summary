package programtest.newcoder;

import java.util.Scanner;

public class LiFangGen {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double val = input.nextDouble();
        System.out.println(getCubeRoot(val));
    }

    public static double getCubeRoot(double val) {
        return Math.pow(val, 1.0 / 3);
    }
}
