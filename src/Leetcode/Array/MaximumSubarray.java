package Leetcode.Array;

// https://leetcode.com/problems/maximum-subarray/
public class MaximumSubarray {

    int maxValue = Integer.MIN_VALUE;
    int sum = 0;

    public int maxSubArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum > maxValue) {
                maxValue = sum;
            }
            if (sum < 0) {
                sum = 0;
            }

        }
        return maxValue;
    }

}
