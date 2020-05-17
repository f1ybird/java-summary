package programtest.leetcode;

/**
 * @Description: 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 * @Author: zhangkai
 * @Date: 2020/5/17 18:38
 */
public class Palindrome {

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome(123321));
        System.out.println(palindrome.isPalindrome(0));
        System.out.println(palindrome.isPalindrome(1));
        System.out.println(palindrome.isPalindrome(12321));
        System.out.println(palindrome.isPalindrome(12323231));
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int a = 0;

        //反转操作
        while (x > a) {
            a = a * 10 + x % 10;
            x = x / 10;
        }

        return x == a || x == a / 10;
    }
}
