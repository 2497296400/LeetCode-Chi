package 周赛.三百一十五场.统计定界子数组的数目;

import 基础数据结构.线段树.SegmentTree;

import java.security.interfaces.RSAKey;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solition {
    public static void main(String[] args) {
        Solition solition = new Solition();
        int[] arr = {1, 3, 5, 2, 7, 5};
        System.out.println(solition.countSubarrays(arr, 1, 5));
    }

    public long countSubarrays(int[] nums, int minK, int maxK) {
        long sum = 0;
        int left = 0;
        int right = 0;
        int pos1 = -1;
        int pos2 = -1;
        while (right < nums.length) {
            if (nums[right] == minK) {
                pos1 = right;
            }
            if (nums[right] == maxK) {
                pos2 = right;
            }
            if (nums[right] < minK || nums[right] > maxK) {
                left = right + 1;
            }
            right++;
            sum += Math.max(0, Math.min(pos1, pos2) - left + 1);
        }
        return sum;
    }
}