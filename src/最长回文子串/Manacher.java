package 最长回文子串;

public class Manacher {
    public static void main(String[] args) {
        String str="aaa";
        System.out.println(manncher(str));
    }
    public static char[] processChar(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }
    public static int manncher(String str) {
        int max = 0;
        char[] processChar = processChar(str);
        int R = -1, C = -1;
        int[] radiuPath = new int[processChar.length];
        for (int i = 0; i < processChar.length; i++) {
            radiuPath[i] = R > i ? Math.min(radiuPath[2 * C - i], R - i):1;
            while (i + radiuPath[i] < processChar.length && i - radiuPath[i] > -1) {
                if (processChar[i + radiuPath[i]] == processChar[i - radiuPath[i]]) {
                   radiuPath[i]++;
                } else {
                    break;
                }
                if (i + radiuPath[i] > R) {
                    R = i + radiuPath[i];
                    C = i;
                }
            }
            max = Math.max(max, radiuPath[i]);
        }
        return max - 1;
    }
}

