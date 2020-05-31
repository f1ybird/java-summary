package hwtest;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = "";
        int count = 4;
        List<String> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            list.add(input.nextLine());
        }

        int a = 0, b = 0;
        for (int i = 1; i < list.size(); i++) {
            a = Integer.parseInt(list.get(i).split(" ")[0]);
            b = Integer.parseInt(list.get(i).split(" ")[1]);
            if (a > Integer.parseInt(list.get(i - 1).split(" ")[1])) {
                continue;
            }else if(a == Integer.parseInt(list.get(i - 1).split(" ")[0])){

            }
        }

        input.close();
    }
}
