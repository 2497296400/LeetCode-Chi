package Top集合.单词接龙;

import java.util.*;

public class Solution {
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Solution solution = new Solution();
        String f = "a";
        String s = "c";
        String[] c = {"a", "b", "c"};
        List<String> list = new ArrayList<String>(List.of(c));
        System.out.println(solution.ladderLength(f, s, list));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> qf = new LinkedList<>();
        Queue<String> qs = new LinkedList<>();
        qf.add(beginWord);
        qs.add(endWord);
        Set<String> set = new HashSet<>();
        int cf = 0;
        int cs = 0;
        while (!qf.isEmpty()) {
            cf++;
            int size = qf.size();
            for (int i = 0; i < size; i++) {
                String curNode = qf.poll();
                if (Objects.equals(curNode, endWord)) {
                    return ans;
                }
                for (String word : wordList) {
                    if (!set.contains(word) && toCheck(curNode, word)) {
                        set.add(word);
                        qf.add(word);
                    }
                }
            }
            size = qs.size();
            cs++;
            for (int i = 0; i < size; i++) {
                String curNode = qs.poll();
                for (String word : wordList) {
                    if (toCheck(curNode, word)) {
                        qs.add(word);
                        if (set.contains(curNode)) {
                            return cf + cs;
                        }
                    }
                }
            }
        }
        return 0;
    }

    private boolean toCheck(String f, String s) {
        int count = 0;
        for (int i = 0; i < f.length(); i++) {
            if (f.charAt(i) != s.charAt(i)) {
                if (++count > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
