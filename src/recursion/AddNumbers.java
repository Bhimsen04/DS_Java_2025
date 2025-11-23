package recursion;

public class AddNumbers {
    public static void main(String[] args) {
        int[] arr = {4, 1, 9, 3, 5};

        int sum = sumRec(arr, arr.length - 1);
        System.out.println(sum);
    }

    private static int sumRec(int[] arr, int l) {
        if (l >= 0) {
            return arr[l] + sumRec(arr, l - 1);
        }
        return 0;

    }
}
