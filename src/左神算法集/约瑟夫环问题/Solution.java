package 左神算法集.约瑟夫环问题;

public class Solution {
    public int getLive(int n, int m) {
        if (n == 1) {
            return 1;
        }
        return (getLive(n - 1, m) + m - 1) % n + 1;
    }
}
