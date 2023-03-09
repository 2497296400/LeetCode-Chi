package 周赛.三百二十五自己傻逼场.第二题逆向滑动;

public class Solution {
    int curMin = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "caaababcaa";

        System.out.println(solution.takeCharacters(s, 2));
    }

    public int takeCharacters(String s, int k) {
        int r = s.length();
        int[] arr = new int[3];
        char[] ca = s.toCharArray();
        while (getMin(arr) < k) {
            arr[ca[--r] - 'a']++;
            if (getMin(arr) < k) {
                if (r == 0) {
                    return -1;
                }
            }
        }
        int ans = s.length() - r;
        int l = 0;
        for (int i = 0; i < ca.length; i++) {
            arr[ca[i] - 'a']++;
            while (r < s.length() && arr[ca[r] - 'a'] > k) {
                arr[ca[r] - 'a']--;
                r++;
            }
            ans = Math.min(ans, i + s.length() - r + 1);
            if (r == s.length()) {
                return ans;
            }
        }
        return ans;
    }

    private int getMin(int[] arr) {
        int cur = Integer.MAX_VALUE;
        for (int i : arr) {
            cur = Math.min(cur, i);
        }
        return cur;
    }
}
