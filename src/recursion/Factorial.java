package recursion;

public class Factorial {

    public static void main(String[] args) {
        int sum = factorial(5);
        System.out.println(sum);
    }

    private static int factorial(int l) {
        if (l > 0) {
            return l * factorial(l - 1);
        }
        return 1;

    }
}
