package 周赛.三百四十七场.使所有字符相等的最小成本;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumCost("010101"));
    }

    public long minimumCost(String s) {
        char[] charArray = s.toCharArray();
        return Math.min(getZ(charArray, '0'), getZ(charArray, '1'));
    }

    private long getZ(char[] charArray, char c) {
        long ans = 0;
        int l = 0, r = 0;
        while (l < charArray.length) {
            if (charArray[r] == c) {
                while (r < charArray.length && charArray[r] == c) {
                    r++;
                }
                ans += Math.min(r, charArray.length - r);
                ans += Math.min(l, charArray.length - l);
                l = r;
            }
            l++;
            r = l;
        }
        return ans;
    }
}
