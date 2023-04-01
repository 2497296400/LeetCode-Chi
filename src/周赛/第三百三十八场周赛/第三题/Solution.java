package 周赛.第三百三十八场周赛.第三题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 1, 6, 8};
        int[] srr = {1, 5};
        System.out.println(solution.minOperations(arr, srr));
    }

    public List<Long> minOperations(int[] nums, int[] queries) {
        List<Long> asn = new ArrayList<>();
        Arrays.sort(nums);
        long[] pre = new long[nums.length];
        pre[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int taget = queries[i];
            int curIndex = getIndex(taget, nums);
            if (curIndex == -1) {
                asn.add(pre[pre.length - 1] - (long) pre.length * taget);
            } else {
                long curAns = getAns(taget, curIndex, pre);
                asn.add(curAns);
            }
        }
        return asn;
    }

    private long getAns(int taget, int curIndex, long[] pre) {
        long preMax = (long) taget * (curIndex + 1) - pre[curIndex];
        long lastMax = (pre[pre.length - 1] - pre[curIndex]) - (long) taget * (pre.length - curIndex - 1);
        return preMax + lastMax;
    }

    private int getIndex(int taget, int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int flag = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == taget) {
                return mid;
            } else if (nums[mid] < taget) {
                flag = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return flag;
    }
}
