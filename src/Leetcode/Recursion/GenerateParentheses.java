package Leetcode.Recursion;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/description/
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(list, new char[n * 2], n * 2, 0, 0, 0);
        return list;
    }

    private void generate(List<String> list, char[] ch, int n, int idx, int ob, int cb) {
        if (idx == n) {
            list.add(new String(ch));
        }
        if (ob < n / 2) {
            ch[idx] = '(';
            generate(list, ch, n, idx + 1, ob + 1, cb);
        }
        if (cb < ob) {
            ch[idx] = ')';
            generate(list, ch, n, idx + 1, ob, cb + 1);
        }
    }
}
