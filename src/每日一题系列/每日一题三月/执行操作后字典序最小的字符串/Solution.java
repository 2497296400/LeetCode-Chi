package 每日一题系列.每日一题三月.执行操作后字典序最小的字符串;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "43987654";
        System.out.println(solution.findLexSmallestString(s, 7, 3));
    }

    public String findLexSmallestString(String s, int a, int b) {
        Deque<String> queue = new LinkedList<>();
        queue.add(s);
        HashSet<String> set = new HashSet<>();
        set.add(s);
        String ans = s;
        while (!queue.isEmpty()) {
            s = queue.poll();
            if (ans.compareTo(s) > 0) {
                ans = s;
            }
            String f = toCheck(s, a);
            String next = getNext(f, b);
            for (String s1 : List.of(f, next)) {
                if (set.add(s1)) {
                    queue.add(s1);
                }
            }
        }
        return ans;
    }

    private String toCheck(String poll, int a) {
        char[] chars = poll.toCharArray();
        for (int i = 1; i < chars.length; i += 2) {
            chars[i] = (char) ((((chars[i] - '0') + a) % 10) + '0');
        }

        return new String(chars);
    }

    private String getNext(String peek, int b) {
        String s = "";
        s = peek.substring(b) + peek.substring(0, b);
        return s;
    }
}
