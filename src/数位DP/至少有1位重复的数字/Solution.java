package 数位DP.至少有1位重复的数字;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDupDigitsAtMostN(20));
    }

    public int numDupDigitsAtMostN(int n) {
        String value = String.valueOf(n);
        char[] chars = value.toCharArray();
        Integer[][] dp = new Integer[chars.length][chars.length];
        return getFun(chars, 0, 0, new int[10], false, true, dp);
        
    }

    private int getFun(char[] chars, int index, int curNumber, int[] curChar, boolean isNum, boolean isLimit, Integer[][] map) {
        if (index == chars.length) {
            return curNumber > 1 ? 1 : 0;
        }
        int ans = 0;
        if (!isNum) {
            ans = getFun(chars, index + 1, curNumber, curChar, false, false, map);
        }
        if (isNum && !isLimit && map[index][curNumber] != null) {
            return map[index][curNumber];
        }
        int up = isLimit ? chars[index] - '0' : 9;
        for (int i = isNum ? 0 : 1; i <= up; i++) {
            ++curChar[i];
            curNumber = getMax(curChar);
            ans += getFun(chars, index + 1, curNumber,
                    curChar, true, isLimit && (i == up), map);
            --curChar[i];
            
        }
        if (isNum && !isLimit) {
            map[index][curNumber] = ans ;
        }
        return ans;
    }
    
    private int getMax(int[] curChar) {
        return Arrays.stream(curChar).max().getAsInt();
    }
}
