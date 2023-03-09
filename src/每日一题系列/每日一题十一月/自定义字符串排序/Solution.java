package 每日一题系列.每日一题十一月.自定义字符串排序;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "cba";
        String s2 = "abcd";
        System.out.println(solution.customSortString2(s1, s2));
    }

    public String customSortString(String order, String s) {
        HashMap<Character, Integer> cur = new HashMap<>();
        char[] cc = order.toCharArray();
        char[] sc = s.toCharArray();
        for (char c : sc) {
            cur.put(c, cur.getOrDefault(c, 0) + 1);
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < cc.length; i++) {
            if (cur.containsKey(cc[i])) {
                ans.append(String.valueOf(cc[i]).repeat(Math.max(0, cur.get(cc[i]))));
                cur.remove(cc[i]);
            }
        }
        for (Character character : cur.keySet()) {
            ans.append(character);
        }
        return String.valueOf(ans);
    }

    public String customSortString2(String order, String s) {
        char[] cc = order.toCharArray();
        char[] sc = s.toCharArray();
        Character[] cur = new Character[sc.length];
        int len = 0;
        for (char c : sc) {
            cur[len++] = c;
        }

        int[] vis = new int[26];
        for (int i = 0; i < cc.length; i++) {
            vis[cc[i] - 'a'] = i + 1;
        }

        Arrays.sort(cur, (Comparator.comparingInt(o -> vis[o - 'a'])));
        Arrays.sort(cur, (Comparator.comparingInt(o -> vis[o - 'a'])));
        return Arrays.toString(cur);
    }
}