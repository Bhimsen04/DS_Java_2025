package Leetcode.BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class Painters_Partition {
    // https://www.interviewbit.com/problems/painters-partition-problem/
    public static void main(String[] args) {
        int paint = paint(2, 1, new ArrayList(List.of(1, 8, 11, 3)));
        System.out.println(paint);
    }

    public static int paint(int painters, int unitOfTime, ArrayList<Integer> boards) {
        if (boards.size() == 1) {
            return boards.get(0) * unitOfTime;
        }
        int low = 0;
        int high = 0;
        for (int i = 0; i < boards.size(); i++) {
            high += boards.get(i);
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isValid(painters, mid, boards)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low * unitOfTime;
    }

    private static boolean isValid(int painters, int mid, ArrayList<Integer> boards) {
        int i = 0;
        int N = boards.size();
        while (i < N && painters > 0) {
            int sum = 0;
            while (i < N && sum + boards.get(i) <= mid) {
                sum = sum + boards.get(i);
                i++;
            }
            painters--;
        }
        return i == N;
    }
}
