package programtest.newcoder;

import java.util.HashSet;
import java.util.Scanner;

public class CountNum {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        char[] chars = line.toCharArray();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < 0 || chars[i] > 127 || chars[i] == '\n') {
                continue;
            }
            set.add(chars[i] + "");
        }
        System.out.println(set.size());
    }
}
