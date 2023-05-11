package 周赛.三百四十场周赛.第一题;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.check(841));
    }

    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        int x1 = 0, y1 = 0, x2 = 0, y2 = m - 1;
        int len = 0;
        HashSet<Integer> set = new HashSet<>();
        while (x1 < n) {
            set.add(nums[x1++][y1++]);
        }
        while (x2 < n) {
            set.add(nums[x2++][y2--]);
        }
        int[] arr = new int[set.size()];
        for (Integer integer : set) {
            arr[len++] = integer;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (check(arr[i])) {
                return arr[i];
            }
        }
        return -1;
    }

    private boolean check(int nextInt) {
        if (nextInt < 3) {
            return nextInt > 1;
        }
        if (nextInt % 6 != 1 && nextInt % 6 != 5) {
            return false;
        }
        for (int i = 5; i * i <= nextInt; i += 6) {
            if (nextInt % i == 0 || nextInt % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
