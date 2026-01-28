package Leetcode.BinarySearch;

// // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class Floor_Ceil {
    public int[] searchRange(int[] nums, int target) {
        int floorIdx = bs_floor(nums, nums.length - 1, target);
        int ceilIdx = bs_ceil(nums, nums.length - 1, target);
        int[] arr = {floorIdx, ceilIdx};
        return arr;
    }

    public int bs_floor(int[] arr, int N, int searchEle) {
        int l = 0, h = N, ans = -1;
        while (l <= h) {
            int m = (l + h) / 2;
            if (searchEle <= arr[m]) {
                if (searchEle == arr[m]) {
                    ans = m;
                }
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    public int bs_ceil(int[] arr, int N, int searchEle) {
        int l = 0, h = N, ans = -1;
        while (l <= h) {
            int m = (l + h) / 2;
            if (searchEle >= arr[m]) {
                if (searchEle == arr[m]) {
                    ans = m;
                }
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return ans;
    }

}
