package 灵神总结周赛.模拟.大数相加;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.additionOfLargeNumbers("91423413299", "104231654321320"));
    }

    public String additionOfLargeNumbers(String f, String s) {
        int fLen = f.length() - 1;
        int sLen = s.length() - 1;
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        while (fLen >= 0 || sLen >= 0) {
            int fa = fLen >= 0 ? f.charAt(fLen--) - '0' : 0;
            int sa = sLen >= 0 ? s.charAt(sLen--) - '0' : 0;
            int curSum = fa + sa + carry;
            carry = curSum / 10;
            curSum = curSum % 10;
            ans.append(curSum);
        }
        if (carry != 0) {
            ans.append(carry);
        }
        return ans.reverse().toString();
    }
}
