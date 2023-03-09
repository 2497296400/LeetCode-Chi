package 周赛.三百零七.最大回文数字;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestPalindromic("00000999"));
    }

    public String largestPalindromic(String num) {
        int[] ans = new int[10];
        char[] chars = num.toCharArray();
        for (char aChar : chars) {
            ans[aChar - '0']++;
        }
        StringBuilder sbF = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            int cur = ans[i] / 2;
            char curar = (char) (i + '0');
            if(i==0&&sbF.length()==0){
                break;
            }
            sbF.append(String.valueOf(curar).repeat(Math.max(0, cur)));
            ans[i] -= cur * 2;
        }
        StringBuilder sbS = new StringBuilder(sbF);
        sbS.reverse();
        for (int i = 9; i >= 0; i--) {
            if (ans[i] > 0) {
                sbF.append((char) (i + '0'));
                break;
            }
        }
        sbF.append(sbS);
        return String.valueOf(sbF);
    }

    private void fun(Data data, StringBuilder stringBuilder) {
        char aChar = data.aChar;
        int curSum = data.curSum;
        while (curSum > 1) {
            stringBuilder.insert(0, aChar);
            stringBuilder.append(aChar);
            curSum -= 2;
        }
    }
}

class Data {
    char aChar;
    int curSum;

    public Data(char aChar, int curSum) {
        this.aChar = aChar;
        this.curSum = curSum;
    }
}