package 周赛.三百一十七.可被三整除的偶数的平均值;

public class Solution {
    public int averageValue(int[] nums) {
        int sum = 0;
        int len = 0;
        for (int num : nums) {
            if(num%3==0&&num%2==0){
                sum+=num;
                len++;
            }
        }
        if(len==0){
            return 0;
        }
        return  sum/len;
    }
}
