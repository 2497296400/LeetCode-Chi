package Top集合.单词拆分II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "catsanddog";
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");
        System.out.println(solution.wordBreak(s, list));
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        Set<String> strings = new HashSet<>(wordDict);
        fun(s, strings, 0, result, "");
        return result;

    }

    private void fun(String s, Set<String> strings, int curIndex, List<String> result, String curAnswer) {
        if (curIndex == s.length()) {
            String strip = curAnswer.strip();
            result.add(strip);
        }
        for (int i = curIndex; i < s.length(); i++) {
            String temp = s.substring(curIndex, i + 1);
            if(strings.contains(temp)){
                fun(s, strings, i+1, result, curAnswer+temp+" ");
            }
        }
    }
}
