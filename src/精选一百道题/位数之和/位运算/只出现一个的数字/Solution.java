package 精选一百道题.位数之和.位运算.只出现一个的数字;

public class Solution {
    public int singleNumber(int[] nums) {
        int singe = 0;
        for(var num:nums){
            singe^=num;
        }
        return singe;
    }
}
