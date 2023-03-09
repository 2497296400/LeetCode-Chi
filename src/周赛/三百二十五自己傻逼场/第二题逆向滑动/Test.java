package 周赛.三百二十五自己傻逼场.第二题逆向滑动;

public class Test {
    public int takeCharacters(String s, int k) {
        char[] cs = s.toCharArray();
        int[] srr = new int[3];
        for (int i = 0; i < cs.length; i++) {
            int index = cs[i] - 'a';
            srr[index]++;
        }
        if (getMin(srr) < k) {
            return -1;
        }
        int l = 0;
        int ans = 0;
        for (int i = 0; i < cs.length; i++) {
            int curIndex = cs[i] - 'a';
            srr[curIndex]--;
            while (srr[curIndex] < k) {
                srr[cs[l++] - 'a']++;
            }
            ans = Math.max(ans, i - l + 1);
        }
        return cs.length - ans;
    }

    private int getMin(int[] arr) {
        int cur = Integer.MAX_VALUE;
        for (int i : arr) {
            cur = Math.min(cur, i);
        }
        return cur;
    }
}
