package 灵神总结周赛.模拟.有效时间的数目;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countTime("2?:??"));
    }

    public int countTime(String time) {
        char[] chars = time.toCharArray();
        int ans = 1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                if (i == 0) {
                    if (chars[i + 1] >= '5' && chars[i + 1] <= '9') {
                        ans *= 2;
                    } else {
                        ans *= 3;
                    }
                }
                if (i == 1) {
                    if (chars[i - 1] == '2') {
                        ans *= 4;
                    } else if (chars[i - 1] == '?') {
                        ans = (ans - 1) * 10 + 4;
                    } else {
                        ans *= 10;
                    }
                }
                if (i == 3) {
                    ans *= 6;
                }
                if (i == 4) {
                    ans *= 10;
                }
            }
        }
        return ans;
    }
}
