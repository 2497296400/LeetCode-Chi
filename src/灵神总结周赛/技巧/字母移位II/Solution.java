package 灵神总结周赛.技巧.字母移位II;

public class Solution {
    static int[] tree;
    static int N;

    public int query(int index) {
        int ans = 0;
        while (index > 0) {
            ans += tree[index];
            index -= lotbit(index);
        }
        return ans;

    }

    public int lotbit(int i) {
        return i & (-i);
    }

    public void add(int i, int target) {
        while (i <= N) {
            tree[i] += target;
            i += lotbit(i);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{0, 1, 1}};
        System.out.println(solution.shiftingLetters("a", arr));
    }

    public String shiftingLetters(String s, int[][] shifts) {
        N = s.length() + 1;
        tree = new int[N + 1];
        for (int[] shift : shifts) {
            int p = shift[2] == 1 ? 1 : -1;
            add(shift[0] + 1, -26);
            add(shift[1] + 2, -p);
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int query = query(i + 1);
            chars[i] = fun(chars, i, query);
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
