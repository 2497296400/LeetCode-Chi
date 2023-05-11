package 灵神总结周赛.技巧.找到所有好下标;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.goodIndices(new int[]{878724, 201541, 179099, 98437, 35765, 327555, 475851, 598885, 849470, 943442
        }, 4));
    }

    public List<Integer> goodIndices(int[] nums, int k) {
        int[] pre = new int[nums.length];
        int[] next = new int[nums.length];
        Arrays.fill(pre, 1);
        Arrays.fill(next, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                pre[i] = pre[i - 1] + 1;
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] >= nums[i]) {
                next[i] = next[i + 1] + 1;
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = k; i < nums.length - k; i++) {
            if (pre[i - 1] >= k && next[i + 1] >= k) {
                arrayList.add(i);
            }
        }
        return arrayList;
    }
}
