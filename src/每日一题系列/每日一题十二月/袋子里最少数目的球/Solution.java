package 每日一题系列.每日一题十二月.袋子里最少数目的球;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {9};
        System.out.println(solution.minimumSize(arr, 2));
    }

    public int minimumSize(int[] nums, int maxOperations) {

        int curMax = 0;
        for (int num : nums) {
            curMax = Math.max(num, curMax);
        }
        int l = 1;
        int r = curMax;
        int pos = curMax;
            while (l <= r) {
                int cnt = 0;
                int mid = l + (r - l) / 2;
                for (int num : nums) {
                    cnt += num / mid;
                    if (num % mid == 0) {
                        cnt--;
                    }
                }
                if (cnt <= maxOperations) {
                    pos = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return pos;
        }
}
