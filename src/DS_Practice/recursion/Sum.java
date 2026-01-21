package DS_Practice.recursion;

public class Sum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int res = sum(arr, arr.length);
        System.out.println(res);
    }

    private static int sum(int[] arr, int length) {
        if (length == 0) return 0;
        return sum(arr, length - 1) + arr[length - 1];
    }
}
