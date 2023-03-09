package 周赛.三百三十二场.统计公平数对的数目;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0,0,0,0,0,0};
        System.out.println(solution.countFairPairs2(arr, 0,0));
    }

    //三指针
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        if (nums.length <= 1) {
            return 0;
        }
        int f = nums.length - 1;
        int s = nums.length - 1;
        int curIndex = 0;
        long preAns = 0;
        while (curIndex < s) {
            long cur = nums[curIndex];
            while (f > curIndex) {
                if (cur + nums[f] < lower) {
                    break;
                }
                f--;
            }
            while (s > curIndex) {
                if (cur + nums[s] <= upper) {
                    break;
                }
                s--;
            }
            preAns += s - Math.max(f, curIndex);
            curIndex++;
        }
        return preAns;
    }

    //二分
    public long countFairPairs2(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0L;
        for (int i = 0; i < nums.length; i++) {
            int l = getLeftMore(nums, lower - nums[i], i+1);
            int r = getRightLess(nums, upper - nums[i], i+1);
            System.out.println(l+" "+ r);
            if(l==-1||r==-1){
                continue;
            }
            ans += r - l+1;
        }
        return ans;
    }

    private int getRightLess(int[] nums, int target, int l) {
        int r = nums.length - 1;
        int flag = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
                flag = mid;
            } else {
                r = mid - 1;
            }
        }
        return flag;
    }
    private int getLeftMore(int[] nums, int target, int l) {
        int r = nums.length - 1;
        int flag = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid - 1;
                flag = mid;
            } else {
                l = mid + 1;
            }
        }
        return flag;
    }

}