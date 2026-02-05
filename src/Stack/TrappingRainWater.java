package Stack;

import java.util.Stack;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = trap(arr);
        System.out.println(trap);
    }

    public static int trap(int[] arr) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int NRI = i;
            int NRE = arr[i];
            while (!stack.isEmpty() && NRE > arr[stack.peek()]) {
                int CI = stack.pop();
                int CE = arr[CI];
                if (stack.isEmpty()) {
                    break;
                }
                int NLI = stack.peek();
                int NLE = arr[NLI];
                int width = NRI - NLI - 1;
                int height = Math.min(NRE, NLE) - CE;
                sum += width * height;
            }
            stack.push(i);
        }
        return sum;
    }
}
