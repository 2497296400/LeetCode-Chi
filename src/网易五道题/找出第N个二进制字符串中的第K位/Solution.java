package 网易五道题.找出第N个二进制字符串中的第K位;

public class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        }
        int mid = (int) Math.pow(2, n - 1);
        if (k == mid) {
            return '1';
        }
        if (k < mid) {
            return findKthBit(n - 1, k);
        } else {
            return invert(findKthBit(n - 1, 2 * mid - k));
        }
    }
    private char invert(char kthBit) {
        return kthBit == '0' ? '1' : '0';
    }
}
