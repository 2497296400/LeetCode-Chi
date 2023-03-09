package 每日一题系列.每日一题十一月.匹配子序列的单词数;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcde";
        String[] strings = {"a", "bb", "acd", "ace"};
        System.out.println(solution.numMatchingSubseq(s, strings));
    }

    public int numMatchingSubseq(String curs, String[] words) {
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }
        char[] cur = curs.toCharArray();
        for (int i = 0; i < cur.length; i++) {
            pos[cur[i] - 'a'].add(i);
        }
        int res = words.length;
        for (String word : words) {
            if (word.length() > curs.length()) {
                res--;
                continue;
            }
            int p = -1;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (pos[c - 'a'].isEmpty() || pos[c - 'a'].get(pos[c - 'a'].size() - 1) <= p) {
                    --res;
                    break;
                }
                p = getB(pos[c - 'a'], p);
            }
        }
        return res;
    }

    private int getB(List<Integer> po, int targe) {
        int left = 0;
        int right = po.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (po.get(mid) > targe) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return po.get(left);
    }
}