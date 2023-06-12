package 周赛.三百四十八场.第一题;

import java.util.HashSet;

public class Solution {
    public int minimizedStringLength(String s) {
        char[] charArray = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (char c : charArray) {
            set.add(c);
        }
        return set.size();
    }
}
