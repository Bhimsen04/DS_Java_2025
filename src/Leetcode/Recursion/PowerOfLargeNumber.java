package Leetcode.Recursion;

public class PowerOfLargeNumber {

    public static void main(String[] args) {
        int a = 2;
        int b = 9;
        System.out.println(calcPow(a, b));
        System.out.println(calcPow2(a, b));

    }

    private static int calcPow(int a, int b) {
        if (b == 1) {
            return a;
        }
        int ans = calcPow(a, b / 2);
        ans *= ans;
        if (b % 2 == 1) {
            ans *= a;
        }
        return ans;
    }

    static long calcPow2(long a, long b) {
        if (b == 0) {
            return 1;
        }
        long res = calcPow2(a, b / 2);
        res *= res;
        if ((b & 1) == 1) {
            res *= a;
        }
        return res;

    }
}
