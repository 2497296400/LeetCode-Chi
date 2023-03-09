package 精选一百道题.找到所有数组中消失的数字;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] curNums = new int[nums.length];
        for (int num : nums) {
            curNums[num - 1]++;
        }
        List<Integer> ans = new ArrayList<>();
        int len = 1;
        for (int curNum : curNums) {
            if (curNum == 0) {
                ans.add(len);

            }
            len++;

        }
        return ans;
    }
    //原地哈希

//      public List<Integer> findDisappearedNumbers(int[] nums) {
//        int n = nums.length;
//        for (int num : nums) {
//            int x = (num - 1) % n;
//            nums[x] += n;
//        }
//        List<Integer> ret = new ArrayList<Integer>();
//        for (int i = 0; i < n; i++) {
//            if (nums[i] <= n) {
//                ret.add(i + 1);
//            }
//        }
//        return ret;
//    }

}
