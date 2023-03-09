package 周赛.三百二十四场.统计相似字符串对的数目;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = {"aba", "aabb", "abcd", "bac", "aabc"};
        System.out.println(solution.similarPairs(strings));
    }

    public int similarPairs(String[] words) {
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            Set<Character> set = new HashSet<>();
            char[] chars = words[i].toCharArray();
            for (char aChar : chars) {
                set.add(aChar);
            }
            for (int j = i + 1; j < words.length; j++) {
                char[] chars1 = words[j].toCharArray();
                int curLen = 0;
                int falg = 1;
                Set<Character> set1 = new HashSet<>();
                for (char c : chars1) {
                    set1.add(c);
                }
                if (isT(set, set1)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isT(Set<Character> set, Set<Character> set1) {
        if (set.size() != set1.size()) {
            return false;
        }
        for (Character character : set) {
            if(!set1.contains(character)){
                return false;
            }
        }
        return true;

    }
}
