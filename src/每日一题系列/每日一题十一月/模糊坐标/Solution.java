package 每日一题系列.每日一题十一月.模糊坐标;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "(00011)";
        System.out.println(solution.ambiguousCoordinates(s));
    }

    public List<String> ambiguousCoordinates(String s) {
        char[] c = s.toCharArray();
        List<String> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        String cur = s.substring(1, s.length() - 1);
        char[] chars = cur.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            String f = cur.substring(0, i + 1);
            String s1 = cur.substring(i + 1);
            map.put(f, s1);
        }
        HashSet<String> set = new HashSet<>();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String f = entry.getKey();
            String ss = entry.getValue();
            List<String> f1 = new ArrayList<>();
            List<String> s1 = new ArrayList<>();
            tofun(f, f1);
            tofun(ss, s1);

            for (String s2 : f1) {
                for (String s3 : s1) {
                    StringBuilder curcur = new StringBuilder();
                    curcur.append("(").append(s2).append(", ").append(s3).append(")");
                    set.add(String.valueOf(curcur));
                }
            }
        }
        list.addAll(set);
        return list;
    }

    private void tofun(String f, List<String> f1) {
        char[] array = f.toCharArray();
        if (array[0] != '0'||array.length==1) {
            f1.add(f);
        } else {
            if (array[array.length - 1] == '0') {
                return;
            }
            String s = "";
            String first = f.substring(0, 1);
            s += first + "." + f.substring(1);
            f1.add(s);
            return;
        }
        if (array[array.length - 1] == '0') {
            return;
        }
        for (int i = 0; i < f.length() - 1; i++) {
            String s = "";
            String first = f.substring(0, i + 1);
            s += first + "." + f.substring(i + 1);
            f1.add(s);
        }
    }
}
