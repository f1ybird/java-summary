package programtest.newcoder;

import java.util.Scanner;

public class WordLengthCount {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = "";
        while (input.hasNextLine()) {
            s = input.nextLine();
            String[] split = s.split(" ");
            System.out.println(split[split.length - 1].length());
        }
    }
}