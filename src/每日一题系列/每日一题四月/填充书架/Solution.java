package 每日一题系列.每日一题四月.填充书架;

public class Solution {
    public static void main(String[] args) {
        System.out.println("hellow !!!!!!");
        Solution solution = new Solution();
        int[][] b = {{7, 3}, {8, 7}, {2, 7}, {2, 5}};
        System.out.println(solution.minHeightShelves(b, 10));
    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[] dp = new int[books.length + 1];
        /*    for (int i = 1; i <= books.length; i++) {
                dp[i] = Integer.MAX_VALUE;
                int w = 0, h = 0;
                for (int j = i - 1; j >= 0; j--) {
                    h = Math.max(h, books[j][1]);
                    w += books[j][0];
                    if (w > shelfWidth) {
                        break;
                    }
                    dp[i] = Math.min(dp[i], dp[j] + h);
                }
            }*/
        return fun(books, 0, shelfWidth, dp);
        // return dp[books.length];
    }

    public int fun(int[][] books, int index, int shelfWidth, int[] dp) {
        if (index == books.length) {
            return 0;
        }
        if (dp[index] != 0) {
            return dp[index];
        }
        int ans = Integer.MAX_VALUE;
        int curMax = 0;
        for (int i = index, cur = shelfWidth; cur >= 0 && i < books.length; i++) {
            if (books[i][0] > cur) {
                break;
            }
            cur -= books[i][0];
            curMax = Math.max(curMax, books[i][1]);
            ans = Math.min(ans, fun(books, i + 1, shelfWidth, dp) + curMax);
        }
        dp[index] = ans;

        return ans;
    }
}
