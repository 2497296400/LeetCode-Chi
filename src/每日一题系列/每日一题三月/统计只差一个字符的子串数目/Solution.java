package 每日一题系列.每日一题三月.统计只差一个字符的子串数目;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSubstrings("aba", "baba"));
    }
    
    public int countSubstrings(String s, String t) {
        int ans = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                String cur = s.substring(j, i + 1);
                if (map.containsKey(cur)) {
                    ans += map.get(cur);
                } else {
                    map.put(cur, toGet(cur, i + 1 - j, t));
                    ans += map.get(cur);
                }
            }
        }
        return ans;
    }

    private int toGet(String cur, int len, String t) {
        int ans = 0;
        for (int i = 0; i <= t.length() - len; i++) {
            int difference = 0;
            String curNext = t.substring(i, i + len);
            for (int j = 0; j < curNext.length(); j++) {
                if (curNext.charAt(j) != cur.charAt(j)) {
                    difference++;
                }
                if (difference > 1) {
                    break;
                }
            }
            if (difference == 1) {
                ans++;
            }
        }
        return ans;
    }
}