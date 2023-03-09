package Top集合.单词规律2;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1="asdasdcsdasd";
        String s2 ="aabcd";
        System.out.println(solution.wordRule(s1, s2));
    }
    public boolean wordRule(String s1, String s2) {
        return match(s1, s2, 0, 0, new String[26], new HashSet<String>());
    }

    private boolean match(String target, String pattern, int tl, int pl, String[] map, HashSet<String> check) {
        if (tl == target.length() && pl == pattern.length()) {
            return true;
        }
        if (tl == target.length() || pl == pattern.length()) {
            return false;
        }
        char cp = pattern.charAt(pl);
        String cur = map[cp - 'a'];
        if (cur != null) {
            int curLen = cur.length();
            return tl + curLen < target.length() && target.substring(tl, tl + curLen).equals(cur) && match(target, pattern, tl + curLen, pl + 1, map, check);
        }
        for (int i = tl+1; i <= target.length(); i++) {
            String substring = target.substring(tl, i);
            if (!check.contains(substring)) {
                check.add(substring);
                map[cp - 'a'] = substring;
                if (match(target, pattern, i, pl + 1, map, check)) {
                    return true;
                }
                map[cp-'a']=null;
                check.remove(substring);
            }
        }
        return false;
    }
}
