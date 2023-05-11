package 每日一题系列.每日一题四月.多数元素;

public class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) {
                res = nums[i];
            } else {
                if (nums[i] == res) cnt++;
                else cnt--;
            }
        }
        return res;
    }
}
