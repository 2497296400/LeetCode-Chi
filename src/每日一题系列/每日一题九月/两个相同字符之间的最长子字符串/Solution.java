package 每日一题系列.每日一题九月.两个相同字符之间的最长子字符串;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s="mgntdygtxrvxjnwksqhxuxtrv";
        System.out.println(solution.maxLengthBetweenEqualCharacters(s));
    }
    public int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int curLen = -1;
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], i);
            } else {
                System.out.println(s.substring(map.get(chars[i]), i+1));
                curLen = Math.max(curLen, i - map.get(chars[i]) - 1);
            }
        }
        return  curLen;
    }
}
