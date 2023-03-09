package 左神算法集.多少个子序列;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s="bcc";
        System.out.println(solution.get(s));
    }
    public int get(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int all = 1;
        for (char aChar : chars) {
            int newAll = all;
            int curAll = newAll + all - map.getOrDefault(aChar, 0);
            all = curAll;
            map.put(aChar, newAll);
        }
        return all;
    }
}
