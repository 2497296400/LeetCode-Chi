package 周赛.三百一十一.最小偶倍数;

public class Solution {
    public int smallestEvenMultiple(int n) {
        if(n%2==0){
            return n;
        }else {
            return n*2;

        }
    }
}
