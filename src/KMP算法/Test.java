package KMP算法;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        String s1 = "21,22,21,22,21,22,21,30";
        String s2 = "21,22,21,22,21,30";
        System.out.println(test.getIndex(s1, s2));
    }

    private int getIndex(String s, String f) {
        char[] sc = s.toCharArray();
        char[] fc = f.toCharArray();
        if (s.length() < f.length()) {
            return -1;
        }
        int[] next = getNext(fc);
        int fLen = 0;
        int sLen = 0;
        while (sLen < s.length() && fLen < f.length()) {
            if (fc[fLen] == sc[sLen]) {
                fLen++;
                sLen++;
            } else if (next[fLen] != -1) {
                fLen = next[fLen];
            } else {
                sLen++;
            }
        }
        return fLen == f.length() ? sLen-fLen: -1;
    }
    
    private int[] getNext(char[] fc) {
        int[] next = new int[fc.length];
        next[0] = -1;
        int lasPre = 2;
        int curCnt = 0;
        while (lasPre < fc.length) {
            if (fc[lasPre - 1] == fc[curCnt]) {
                next[lasPre++] = ++curCnt;
            } else if (next[curCnt] != -1) {
                curCnt = next[curCnt];
            } else {
                next[lasPre++] = 0;
            }
        }
        return next;
    }
}