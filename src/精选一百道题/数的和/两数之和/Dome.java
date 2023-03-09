package 精选一百道题.数的和.两数之和;

import java.util.Arrays;

public class Dome {

    public static void main(String[] args) {
        Solution s=new Solution();
        int []nums={0,0,3,4};
        int target=0;
        System.out.println(Arrays.toString(s.twoSum(nums, target)));
    }
}
