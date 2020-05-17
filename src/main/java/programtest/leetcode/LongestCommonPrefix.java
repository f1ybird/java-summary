package programtest.leetcode;

/**
 * @Description: 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * @Author: zhangkai
 * @Date: 2020/5/17 22:45
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix commonPrefix = new LongestCommonPrefix();
        System.out.println(commonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {

            //退出条件：strs[i]存在prefix子串的下标为0或者空
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }

        }
        return prefix;
    }
}
