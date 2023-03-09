package 周赛.三百一十场.子字符串的最优划分;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s="abacaba";
        System.out.println(solution.partitionString(s));
    }
    public int partitionString(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        int ans = 0;
        while (end < chars.length && start < chars.length) {
            if (set.contains(chars[start])) {
                set = new HashSet<>();
                set.add(chars[start]);
                ans++;
                end = ++start;
            } else if(start<chars.length){
                set.add(chars[start++]);
            }
        }
        return  ++ans;
    }
}
