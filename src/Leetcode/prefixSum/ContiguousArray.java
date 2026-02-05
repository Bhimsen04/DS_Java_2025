package Leetcode.prefixSum;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/contiguous-array/
public class ContiguousArray {

    public static void main(String[] args) {
        int maxLength = findMaxLength(new int[]{0, 1, 1, 1, 1, 1, 0, 0, 0});
        System.out.println(maxLength);
    }

    public static int findMaxLength(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0;
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
            prefixSum += nums[i];
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            } else {
                max = Math.max(max, i - map.get(prefixSum));
            }
        }
        return max;
    }
}
