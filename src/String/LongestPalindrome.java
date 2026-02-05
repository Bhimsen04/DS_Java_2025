package String;

// https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindrome {

    public static void main(String[] args) {

    }

    public String longestPalindrome(String s) {

        int maxLength = -1;
        int start = 0;
        int end = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            maxLength = maxLength(i - 1, i + 1, s);
            if (2 * maxLength + 1 > result) {
                result = 2 * maxLength + 1;
                start = i - maxLength;
                end = i + maxLength;
            }
            maxLength = maxLength(i, i + 1, s);
            if (2 * maxLength > result) {
                result = 2 * maxLength;
                start = i - maxLength + 1;
                end = i + maxLength;
            }
        }
        return s.substring(start, end + 1);
    }

    int maxLength(int first, int second, String s) {
        int maxLength = 0;
        for (int i = first, j = second; i >= 0 && j < s.length(); i--, j++) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            maxLength++;
        }
        return maxLength;
    }
}
