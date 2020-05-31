package hwtest;

import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = "";
        String result = "";
        int count = input.nextInt();
        while (input.hasNext()) {
            for (int j = 0; j < count; j++) {
                str = input.nextLine();
                for (int i = 0; i < str.length(); i++) {
                    char c;
                    if (i == 0) {
                        c = (char) (str.charAt(i) + 1);
                        if (c > 'z') {
                            c = (char) (c - 'z' + 96);
                        }
                        result += c;
                    } else if (i == 1) {
                        c = (char) (str.charAt(i) + 2);
                        if (c > 'z') {
                            c = (char) (c - 'z' + 96);
                        }
                        result += c;
                    } else if (i == 2) {
                        c = (char) (str.charAt(i) + 4);
                        if (c > 'z') {
                            c = (char) (c - 'z' + +96);
                        }
                        result += c;
                    } else {
                        c = (char) (str.charAt(i) + getNum(i));
                        if (c > 'z') {
                            c = (char) (c % 'z' + 96);
                        }
                        result += c;
                    }
                }
                System.out.println(result);
            }
        }
        input.close();
    }

    public static int getNum(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 2;
        } else if (n == 2) {
            return 4;
        } else {
            return getNum(n - 1) + getNum(n - 2) + getNum(n - 3);
        }
    }
}
