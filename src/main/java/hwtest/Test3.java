package hwtest;

import java.util.Scanner;
import java.util.Stack;

public class Test3 {

    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "";
        while (sc.hasNext()) {
            str = sc.nextLine();
            String[] split = str.split(" ");
            for (int i = 0; i < split.length; i++) {
                add(Integer.parseInt(split[i]));
            }

            String result = "";
            while (!stack.isEmpty()) {
                result += stack.pop() + " ";
            }
            System.out.println(result.substring(0, result.length() - 1));
        }

    }

    public static void add(int n) {
        if (stack.isEmpty()) {
            stack.push(n);
        } else {
            //判定栈中已有元素是否等于将要入栈的元素
            if (isExist(n)) {
                add(2 * n);
            } else {
                stack.push(n);
            }
        }
    }

    /**
     * 累加
     */
    public static boolean isExist(int n) {
        boolean falg = false;
        int val = 0;
        Stack<Integer> stack2 = new Stack<>();
        while (!stack.isEmpty()) {
            val = val + stack.peek();
            stack2.push(stack.pop());
            if (val == n) {
                falg = true;
                break;
            }
        }

        //取出的元素再放回
        if (!falg) {
            while (!stack2.isEmpty()) {
                stack.push(stack2.pop());
            }
        }

        return falg;
    }


}
