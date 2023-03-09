package 精选一百道题.位数之和.位运算;

public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n>0&&(n&(n-1))==0;
    }
    public boolean isPowerofTwo01(int n){
        if (n<1){
            return false;
        }
        while(n!=1){
            if(n%2!=0){
                return false;
            }
            n=n/2;
        }
    return true;
    }
}
