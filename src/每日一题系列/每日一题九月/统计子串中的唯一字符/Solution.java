package 每日一题系列.每日一题九月.统计子串中的唯一字符;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ABCAAC";
        System.out.println(solution.uniqueLetterString(s));
    }
    public int uniqueLetterString(String s) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(-1);
                map.put(chars[i], arrayList);
            }
            map.get(chars[i]).add(i);
        }
        int sum = 0;
        for (Map.Entry<Character, ArrayList<Integer>> entry : map.entrySet()) {
            ArrayList<Integer> value = entry.getValue();
            value.add(chars.length);
            for (int i = 1; i < value.size()-1; i++) {
                sum += (value.get(i) - value.get(i - 1)) * (value.get(i + 1) - value.get(i));
            }
        }
        return sum;
    }
}