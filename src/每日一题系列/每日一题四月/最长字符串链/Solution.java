package 每日一题系列.每日一题四月.最长字符串链;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] w = {"a", "ab", "ac", "bd", "abc", "abd", "abdd"};
        System.out.println(solution.longestStrChain(w));
    }

    public int longestStrChain(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, 0);
        }
        int ans = 0;
        for (String word : words) {
            ans = Math.max(ans, dfs(word, map));
        }
        return ans;

    }

    private int dfs(String word, HashMap<String, Integer> map) {
        if (map.get(word) > 0) {
            return map.get(word);
        }
        int res = 1;
        for (int i = 0; i < word.length(); i++) {
            String temp = word.substring(0, i) + word.substring(i + 1);
            if (map.containsKey(temp)) {
                res = Math.max(res, dfs(temp, map) + 1);
            }
        }
        map.put(word, res);
        return res;
    }
}