package 灵神总结周赛.技巧.字母移位II;

public class 差分数组 {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] diff = new int[s.length() + 1];
        for (int[] shift : shifts) {
            int p = shift[2] == 1 ? 1 : -1;
            diff[shift[0]] += p;
            diff[shift[1] + 1] -= p;
        }
        int[] pre = new int[diff.length];
        pre[0] = diff[0];
        for (int i = 1; i < pre.length; i++) {
            pre[i] += pre[i - 1] + diff[i];
        }
        char[] chars = s.toCharArray();

        for (int i = 0; i < pre.length; i++) {
            chars[i] = fun(chars, i, pre[i]);
        }
        return String.valueOf(chars);
    }

    private char fun(char[] chars, int i, int query) {
        int cur = chars[i] - 'a';
        cur = cur + query;
        if (cur > 0) {
            cur = cur % 26;
        } else if (cur < 0) {
            cur = Math.abs(cur);
            cur = 26 - (cur % 26);
        }
        cur = cur % 26;
        return (char) (cur + 'a');
    }

}
