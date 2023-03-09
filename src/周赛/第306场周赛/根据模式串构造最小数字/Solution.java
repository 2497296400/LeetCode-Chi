package 周赛.第306场周赛.根据模式串构造最小数字;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String p = "DDD";
        Solution solution = new Solution();
        System.out.println(solution.smallestNumber(p));
    }

    public String smallestNumber(String pattern) {
        char[] chars = pattern.toCharArray();
        int index = 0;
        int cur = 1;
        int len = chars.length;
        int[] ans = new int[len + 1];
        while (index < len) {
            if (chars[index] == 'I') {
                while (index < len && chars[index] == 'I') {
                    ans[index] = cur;
                    index++;
                    cur++;
                }
            }
            int curIndex = index;
            int tempCur = cur;
            if (index < len && chars[index] == 'D') {
                while (index < len && chars[index] == 'D') {
                    index++;
                    tempCur++;
                    cur++;
                }
                while (curIndex <= index) {
                    ans[curIndex++] = tempCur;
                    tempCur--;
                }
                index++;
                cur++;
            }
        }
        if (ans[len - 1] == 0) {
            ans[len - 1] = cur;
        }
        char[] chars1 = new char[len + 1];
        for (int i = 0; i <= len; i++) {
            chars1[i] = (char) ((char) ans[i] + '0');
        }
        int[] nums = new int[pattern.length()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        return String.valueOf(chars1);
    }
}

