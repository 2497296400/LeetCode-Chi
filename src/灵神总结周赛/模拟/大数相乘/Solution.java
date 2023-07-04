package 灵神总结周赛.模拟.大数相乘;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.MultiplicationOfLargeNumbers("511126", "101132"));

    }

    public String MultiplicationOfLargeNumbers(String f, String s) {
        int fLen = f.length() - 1, sLen = s.length() - 1;
        int[] asn = new int[fLen + sLen + 2];
        for (int i = fLen; i >= 0; i--) {
            for (int j = sLen; j >= 0; j--) {
                int curSum = (f.charAt(i) - '0') * (s.charAt(j) - '0');
                int sum = curSum + asn[i + j + 1];
                asn[i + j + 1] = sum % 10;
                asn[i + j] += sum / 10;
            }
            System.out.println(Arrays.toString(asn));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < asn.length; i++) {
            if (i == 0 && asn[i] == 0) {
                continue;
            }
            stringBuilder.append(asn[i]);
        }
        return stringBuilder.toString();
    }
}
