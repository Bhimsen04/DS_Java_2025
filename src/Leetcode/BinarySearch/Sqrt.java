package Leetcode.BinarySearch;

// https://leetcode.com/problems/sqrtx/description/
public class Sqrt {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(mySqrt(n));
    }

    private static int mySqrt(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid * mid == n) {
                return mid;
            } else if (mid * mid < n) {
                left = mid + 1;
            } else if (mid * mid > n) {
                right = mid;
            }
        }
        return left - 1;
    }
}
