package KMP算法;

public class Solution {
    public static void main(String[] args) {
        String s1 = "21,22,21,22,21,22,21,30";
        String s2 = "21,22,21,22,21,30";
        System.out.println(strStr(s1, s2));
    }

    public static int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        char[] hC = haystack.toCharArray();
        char[] nC = needle.toCharArray();
        int[] next = getNextArray(nC);
        int hcLen = 0;
        int ncLen = 0;
        while (hcLen < hC.length && ncLen < nC.length) {
            if (hC[hcLen] == nC[ncLen]) {
                hcLen++;
                ncLen++;
            } else if (next[ncLen] == -1) {
                hcLen++;
            } else {
                ncLen = next[ncLen];
            }
        }
        return ncLen == nC.length ? hcLen - ncLen : -1;
    }

    private static int[] getNextArray(char[] nC) {
        if (nC.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[nC.length];
        next[0] = -1;
        int i = 2;
        int cn = 0;
        while (i < next.length) {
            if (nC[i - 1] == nC[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
