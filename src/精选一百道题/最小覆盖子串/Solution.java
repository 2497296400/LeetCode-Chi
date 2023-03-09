package 精选一百道题.最小覆盖子串;

import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String s1 = "ab";
        String s2 = "b";
        System.out.println(minWindow1(s1, s2));
        System.out.println(minWindow1(s, t));
    }

    //此方法超出时间限制

    public static class Node {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Node() {

        }
    }

    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        if (s.length() == 1 && t.equals(s)) {
            return t;

        }
        int[] flagT = new int[128];
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int len = 0;
        TreeMap<Integer, Node> treeMap = new TreeMap<>(Comparator.comparingInt(o -> o));
        for (char c : tChar) {
            flagT[c]++;
        }
        for (int j = 0; j < sChar.length; j++) {
            int[] flagS = new int[128];
            int strat = j;
            int end = j;
            for (int i = j; i < sChar.length; i++) {
                flagS[sChar[i]]++;
                if (isTUre(flagS, flagT)) {
                    treeMap.put(end - strat, new Node(strat, end));
                }
                end++;
            }
        }
        if (!treeMap.isEmpty()) {
            int strat = treeMap.get(treeMap.firstKey()).start;
            int end = treeMap.get(treeMap.firstKey()).end;
            return s.substring(strat, end + 1);
        }
        return "";
    }

    public static boolean isTUre(int[] flags, int[] flagt) {
        for (int i = 0; i < 128; i++) {
            if (flagt[i] != 0) {
                if (flagt[i] > flags[i]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static String minWindow1(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        if (charT.length > charS.length) {
            return "";
        }
        int[] numsT = new int[128];
        for (char c : charT) {
            numsT[c]++;
        }
        int start = 0;
        int end = 0;
        int len = Integer.MAX_VALUE;
        Node node = new Node();
        int i = 0;
        int[] numsS = new int[128];
        for (; i < charS.length;i++) {
            numsS[charS[i]]++;
            if (isTUre(numsS, numsT)) {
                end = i + 1;
                while (isTUre(numsS,numsT)) {
                    numsS[charS[start++]]--;

                }
                if (len > end - start) {
                    len = end - start;
                    node.start = start - 1;
                    node.end = end;
                }
            }
        }
        return s.substring(node.start, node.end);
    }
}
