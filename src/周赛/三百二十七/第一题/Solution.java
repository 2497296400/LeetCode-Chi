package 周赛.三百二十七.第一题;

public class Solution {
    public int maximumCount(int[] nums) {
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if(num>0){
                a++;
            }
            if(num<0){
                b++;
            }
        }
        return Math.max(a, b);
    }
}
