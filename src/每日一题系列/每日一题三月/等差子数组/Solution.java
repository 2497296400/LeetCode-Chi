package 每日一题系列.每日一题三月.等差子数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] arr={4,6,5,9,3,7};
        int [] l = {0,0,2};
        int [] r = {2,3,5};
        System.out.println(solution.checkArithmeticSubarrays(arr, l, r));
    }
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            ans.add(check(nums, l[i], r[i]));
        }
        return ans;
    }

    private Boolean check(int[] nums, int l, int r) {
        int [] arr = new int[r - l+1];
     
        System.arraycopy(nums, l, arr, 0, r - l+1);
        Arrays.sort(arr);
        int target = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != target) {
                return false;
            }
        }
        return true;
    }
}
