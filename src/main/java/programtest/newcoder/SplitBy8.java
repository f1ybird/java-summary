package programtest.newcoder;

import java.util.Scanner;


public class SplitBy8 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String s = "";

        while (input.hasNext()) {
            s = input.nextLine();
            if ("".equals(s)) {
                continue;
            }
            char[] chars = s.toCharArray();

            if (chars.length % 8 == 0) {// =8
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < chars.length; i += 8) {
                    int count = i;
                    while (sb.length() < 8) {
                        sb.append(chars[count]);
                        count++;
                    }
                    System.out.println(sb.toString());
                    sb = new StringBuffer();
                }
            } else if (chars.length < 8) {// <8
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < chars.length; i++) {
                    sb.append(chars[i]);
                }
                while (sb.length() < 8) {
                    sb.append("0");
                }
                System.out.println(sb.toString());
                sb = new StringBuffer();
            } else {// >8
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < chars.length; i++) {
                    sb.append(chars[i]);
                    if (sb.length() == 8) {
                        System.out.println(sb.toString());
                        sb = new StringBuffer();
                    } else if (i == chars.length - 1) {
                        while (sb.length() < 8) {
                            sb.append("0");
                        }
                        System.out.println(sb.toString());
                        sb = new StringBuffer();
                    }
                }
            }
        }
    }
}