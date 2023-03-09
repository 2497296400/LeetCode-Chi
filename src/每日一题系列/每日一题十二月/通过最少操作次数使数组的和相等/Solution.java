package 每日一题系列.每日一题十二月.通过最少操作次数使数组的和相等;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] arr = {1,5,5,2,1,1,1,1,4,4,4,1,5,2,2,4,6,5,1,5,3,5,6,2,3,1,5,4,4,1,2,4,1,1,6,3,6,4,4,4,3,5,5,5,2,6,4,2,5,4,2,6,3,4,6,1,5,3,2,3,5,2,1,3,2,4,4,4,5,3,5,5,4,1,1,6,5,6,3,5,3,6,5,6,5,4,4,4,5,6,6,6,4,2,4,6,1,2,1,5,3,4,5,5,6,6,1,4,3,1,5,3,4,1,2,1,4,4,5,6,5,3,1,5,1,3,3,6,5,3,5,6,2,6,3,1,2,3,3,1,1,4,3,2,6,6,2,1,2,4,3,5,5,4,3,1,1,5,2,5,1,4,5,6,4,5,2,1,2,5,3,2,6,3,4,3,4,5,4,6,3,4,4,3,3,4,2,2,6,2,6,3,1,1,5,3,1,1,4,2,5,5,5,4,3,6,5,5,5,1,1,3,6,2,3,6,3,4,2,5,4,4,3,5,6,4,3,5,1,1,3,3,1,1,6,4,6,2,1,4,3,5,5};
        int[] srr = {1,2,5,4,3,3,5,1,1,6,2,5,4,4,5,6,6,4,2,5,6,2,3,4,5,2,4,4,3,6,6,5,4,1,2,1,2,3,3,2,6,1,1,1,1,3,5,6,2,1,1,1,4,6,5};
        System.out.println(solution.minOperations(arr, srr));
        Thread.sleep(10000);
    }

    public int minOperations(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length * 6 || nums1.length * 6 < nums2.length) {
            return -1;
        }
        HashMap<Integer, Integer> f = new HashMap<>();
        HashMap<Integer, Integer> s = new HashMap<>();
        int sumf = 0;
        int sums = 0;
        int ans = 0;
        for (int i : nums1) {
            f.put(i, f.getOrDefault(i, 0) + 1);
            sumf += i;
        }
        for (int i : nums2) {
            s.put(i, s.getOrDefault(i, 0) + 1);
            sums += i;
        }
        if (sumf < sums) {
            int target = sums - sumf;
            for (int i = 1, j = 6; i <= 5; i++, j--) {
                int curF = target / (6 - i);
                int curS = target % (6 - i);
                int cur = curF;
                Integer ff = f.get(i);
                Integer ss = s.get(j);
                if (ff != null) {
                    if (curF > ff) {
                        ans += ff;
                        curF -= ff;
                    } else {
                        return ans + curF + (curS == 0 ? 0 : 1);
                    }
                }
                if (ss != null) {
                    if (curF > ss) {
                        ans += ss;
                        curF -= ss;
                    } else {
                        return ans + curF + (curS == 0 ? 0 : 1);
                    }
                }
                target -= (cur - curF) * (6 - i);
                if (target <= 0) {
                    return ans;
                }
            }
        } else if (sumf > sums) {
            int target = sumf - sums;
            for (int i = 6, j = 1; i > 1; i--, j++) {
                int curF = target / (i - 1);
                int curS = target % (i - 1);
                int cur = curF;
                Integer ff = f.get(i);
                Integer ss = s.get(j);
                if (ff != null) {
                    if (curF > ff) {
                        ans += ff;
                        curF -= ff;
                    } else {
                        return ans + curF + (curS == 0 ? 0 : 1);
                    }
                }
                if (ss != null) {
                    if (curF > ss) {
                        ans += ss;
                        curF -= ss;
                    } else {
                        return ans + curF + (curS == 0 ? 0 : 1);
                    }
                }
                target -= (cur - curF) * (i-1);
                if (target <= 0 || curF < 0) {
                    return ans;
                }
            }
        }
        return ans;
    }
}
