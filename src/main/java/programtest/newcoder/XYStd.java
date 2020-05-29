package programtest.newcoder;

import java.util.Scanner;

public class XYStd {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = "";
        while (input.hasNext()) {
            line = input.nextLine();
            int x = 0, y = 0;
            String[] split = line.split(";");
            for (int i = 0; i < split.length; i++) {
                try {
                    if (split[i].length() > 0 && split[i].substring(1).length() > 0 && isNum(split[i].substring(1))) {
                        int num = Integer.parseInt(split[i].substring(1));
                        if ('A' == split[i].charAt(0)) {
                            x -= num;
                        } else if ('D' == split[i].charAt(0)) {
                            x += num;
                        } else if ('W' == split[i].charAt(0)) {
                            y += num;
                        } else if ('S' == split[i].charAt(0)) {
                            y -= num;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            System.out.println(x + "," + y);
        }
    }

    public static boolean isNum(String substring) {
        for (int j = 0; j < substring.length(); j++) {
            if (!Character.isDigit(substring.charAt(j))) {
                return false;
            }
        }
        return true;
    }


}
