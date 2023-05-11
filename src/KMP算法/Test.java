package KMP算法;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        String s1 = "21,22,21,22,21,22,21,30";
        String s2 = "21,22,21,22,21,30";
        System.out.println(test.getIndex(s1, s2));
    }

    private int getIndex(String cur, String target) {
        char[] f = cur.toCharArray();
        char[] s = target.toCharArray();
        int[] next = getNext(s);
        int fLen = 0, sLen = 0;
        while (fLen < f.length && sLen < s.length) {
            if (f[fLen] == s[sLen]) {
                fLen++;
                sLen++;
            } else if (next[sLen] != -1) {
                sLen = next[sLen];
            } else {
                fLen++;
            }
        }
        return sLen == s.length ? fLen - sLen : -1;
    }

    private int[] getNext(char[] s) {
        int[] next = new int[s.length];
        int cnt = 0;
        int preLast = 2;
        next[0] = -1;
        while (preLast < s.length) {
            if (s[preLast - 1] == s[cnt]) {
                next[preLast++] = ++cnt;
            } else if (next[cnt] != -1) {
                cnt = next[cnt];
            } else {
                preLast++;
            }
        }
        return next;
    }
}