package 每日一题系列.每日一题十一月.判断字符串的两半是否相似;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "AbCdEfGh";
        System.out.println(solution.halvesAreAlike(s));
    }

    public boolean halvesAreAlike(String s) {
        char[] arr = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : arr) {
            map.put(c, 0);
        }
        char[] chars = s.toCharArray();
        int len = chars.length / 2;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
            }
        }
        while (len < chars.length) {
            if (map.containsKey(chars[len])) {
                map.put(chars[len], map.getOrDefault(chars[len], 0) - 1);
            }
            len++;
        }
        int sum = 0;
        for (Integer integer : map.values()) {
            sum+=integer;
        }
        return sum==0;
    }
}
