package 精选一百道题.位数之和.位运算.数字范围按位与;

public class Solution {
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(1,2147483647));
    }
    public static int  rangeBitwiseAnd(int left, int right) {
        while(left<right){
            right=right&(right-1);
        }
        return  right;

    }
}
