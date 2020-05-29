package programtest.newcoder;

import java.util.*;

public class ReverseInt {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        List<String> list = new ArrayList<>();
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (!list.contains(chars[i] + "")) {
                list.add(chars[i] + "");
            }
        }
        for (String s : list) {
            System.out.print(s);
        }
    }
}
