package 周赛.三百四十八场.第二题;

public class Solution {

    public int semiOrderedPermutation(int[] nums) {
        int oneIndex = 0;
        int nIndex = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                oneIndex = i;
            }
            if (nums[i] == nums.length) {
                nIndex = i;
            }
        }
        int ans = 0;
        if (oneIndex > nIndex) {
            ans += oneIndex - nIndex;
            nIndex = oneIndex + 1;
        }
        return ans + oneIndex + nums.length - nIndex;
    }
}

