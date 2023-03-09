package 每日一题系列.每日一题七月.串联所有单词的子串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String s = "ababababab";
        String[] words = {"ababa","babab"};
        System.out.println(findSubstring(s, words));
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        char[] schar = s.toCharArray();
        HashMap<String, Integer> wodrMap = new HashMap<>();
        int len = 0;
        for (String word : words) {
            len = word.length();
            wodrMap.put(word, wodrMap.getOrDefault(word, 0) + 1);
        }
        int strat = 0;
        int end = strat + len;
        HashMap<String, Integer> winNap = new HashMap<>(wodrMap);
        int curStrat = 0;
        for (int i = 0; i <= schar.length - words.length ; i++) {
            strat=i;
            winNap = new HashMap<>(wodrMap);
            end=strat+len;
            while (end <= schar.length) {
                String str = "";
                for (int j = strat; j < end; j++) {
                    str += schar[j];
                }
                if (winNap.containsKey(str)) {
                    winNap.put(str, winNap.get(str) - 1);
                    if (winNap.get(str) == 0) {
                        winNap.remove(str);
                    }
                    if (winNap.size() == 0) {
                        ans.add(i);
                    }
                    strat += len;
                    end = strat + len;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}
