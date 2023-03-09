package 周赛.三百零九.检查相同字母间的距离;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abaccb";
        int[] distance = {1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(solution.checkDistances(s, distance));
    }

    public boolean checkDistances(String s, int[] distance) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int index = 0;
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                map.put(aChar, index - map.get(aChar) - 1);
            } else {
                map.put(aChar, index);
            }
            index++;

        }
        int len = 0;
        for (int i : distance) {
            char ar = (char) (len++ + 'a');
            if (map.containsKey(ar) && map.get(ar) != i) {
                return false;
            }
        }
        return true;
    }
}
