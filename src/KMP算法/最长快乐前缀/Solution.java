package KMP算法.最长快乐前缀;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        String str = "abcabcaabcab" ;
        System.out.println(longestPrefix2(str));
    }

    public static String longestPrefix(String s) {
        char[] chars = s.toCharArray();
        Queue<Character> queue = new LinkedList<>();
        int slen = chars.length;

        while (slen > 1) {
            queue.add(chars[--slen]);
        }
        String strEnd = "";
        String strStart = "";
        int flag = 0;

        int size = 0;
        while (!queue.isEmpty()) {
            strEnd = queue.poll() + strEnd;
            strStart = strStart + chars[size++];
            if (strStart.equals(strEnd)) {
                flag = size;
            }
        }
        return s.substring(0, flag);
    }

    public static String longestPrefix2(String s) {
        if (s.length() < 1) {
            return "";
        }
        int count = 0;
        int i = 2;
        int[] next = new int[s.length() + 1];
        next[0] = -1;
        next[1] = 0;
        char[] chars = s.toCharArray();
        while (i <= s.length()) {
            if (chars[i - 1] == chars[count]) {
                next[i++] = ++count;
            } else if (count > 0) {
                count = next[count];
            } else {
                next[i++] = 0;
            }
        }
        return s.substring(0, next[s.length()]);
    }
}