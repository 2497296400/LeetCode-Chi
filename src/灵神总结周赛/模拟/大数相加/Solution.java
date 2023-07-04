package 灵神总结周赛.模拟.大数相加;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.AdditionOfLargeNumbers("91423413299", "104231654321320"));
    }

    public String AdditionOfLargeNumbers(String f, String s) {
        StringBuilder ans = new StringBuilder();
        int fLen = f.length() - 1, sLen = s.length() - 1;
        int carry = 0;
        while (fLen >= 0 && sLen >= 0) {
            int curSum = f.charAt(fLen) - '0' + s.charAt(sLen) - '0' + carry;
            carry = curSum / 10;
            ans.append(curSum % 10);
            fLen--;
            sLen--;

        }
        System.out.println(ans + " " + fLen + " " + sLen);

        while (fLen >= 0) {
            int curSum = f.charAt(fLen) - '0' + carry;
            carry = curSum / 10;
            ans.append(curSum % 10);
            fLen--;
        }
        while (sLen >= 0) {
            int curSum = s.charAt(sLen) - '0' + carry;
            carry = curSum / 10;
            ans.append(curSum % 10);
            sLen--;
        }
        if (carry != 0) {
            ans.append(carry);
        }
        ans.reverse();
        return ans.toString();
    }
}
