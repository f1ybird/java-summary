package programtest.newcoder;

import java.util.Scanner;
import java.util.TreeSet;

public class StrSort {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < num; i++) {
            set.add(input.nextLine());
        }

        for (String s : set) {
            System.out.println(s);
        }
    }
}
