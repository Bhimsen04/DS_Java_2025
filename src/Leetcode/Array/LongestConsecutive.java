package Leetcode.Array;

import java.util.HashSet;

// https://leetcode.com/problems/longest-consecutive-sequence/description/
public class LongestConsecutive {

    public static void main(String[] args) {
        int[] nums = {8, 9, 100, 4, 200, 1, 3, 2, 10, 11, 12, 13};
        int i = longestConsecutive(nums);
        System.out.println(i);
    }

    public static int longestConsecutive(int[] nums) {

        int result = 0;
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int val : set) {
            if (!set.contains(val - 1)) {
                int count = 1;
                while (set.contains(val + count)) {
                    count++;
                }
                result = Math.max(count, result);
            }
        }
        return result;
    }
}
