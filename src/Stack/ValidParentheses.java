package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/description/
public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses parentheses = new ValidParentheses();
        System.out.println(parentheses.isValid("{[]}"));
    }

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (map.containsKey(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || map.get(stack.pop()) != ch) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
