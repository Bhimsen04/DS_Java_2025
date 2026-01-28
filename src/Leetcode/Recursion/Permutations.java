package Leetcode.Recursion;

// https://leetcode.com/problems/permutations/
public class Permutations {

    public static void main(String[] args) {
        String s = "dog";
        permute(s, 0, s.length());
    }

    private static void permute(String s, int l, int r) {
        if (l == r) {
            System.out.println(s);
        } else {
            for (int i = l; i < r; i++) {
                s = swap(s, l, i);
                permute(s, l + 1, r);
                s = swap(s, l, i);
            }
        }
    }

    private static String swap(String s, int l, int r) {
        char[] ch = s.toCharArray();
        char c = ch[l];
        ch[l] = ch[r];
        ch[r] = c;
        return new String(ch);
    }
}
