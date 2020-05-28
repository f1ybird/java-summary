package programtest.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class BracketsIsValid {

    public static void main(String[] args) {
//        BracketsIsValid bracketsIsValid = new BracketsIsValid();
//        System.out.println(bracketsIsValid.isValid("()[]{}"));
//        System.out.println(bracketsIsValid.isValid("(((((())))))"));
//        System.out.println(bracketsIsValid.isValid("()()()()"));

    }

    private Map<Character, Character> mappings;

    public BracketsIsValid() {
        this.mappings = new HashMap<>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char element = s.charAt(i);
            if (this.mappings.containsKey(element)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if (topElement != this.mappings.get(element)) {
                    return false;
                }
            } else {
                stack.push(element);
            }
        }
        return stack.isEmpty();
    }
}
