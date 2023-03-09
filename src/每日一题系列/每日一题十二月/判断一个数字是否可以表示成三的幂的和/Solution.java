package 每日一题系列.每日一题十二月.判断一个数字是否可以表示成三的幂的和;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkPowersOfThree(12));
    }

    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;

        }
        return true;

    }
}