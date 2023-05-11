package 灵神总结周赛.技巧.被列覆盖的最多行数;

public class Solution {
    int ans = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] m = {{0, 0, 0}, {1, 0, 1}, {0, 1, 1}, {0, 0, 1}};
        System.out.println(solution.maximumRows(m, 2));
    }

    public int maximumRows(int[][] matrix, int numSelect) {
        int[] mask = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            mask[i] = get(matrix[i]);
        }
        int ans = 0;
        for (int i = 0; i < 1 << matrix[0].length; i++) {
            int cur = 0;
            if (Integer.bitCount(i) == numSelect) {
                for (int j = 0; j < mask.length; j++) {
                    if ((mask[j] & i) == mask[j]) {
                        cur++;
                    }
                }
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }

    private int get(int[] matrix) {
        int cur = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == 1) {
                cur |= 1 << i;
            }
        }
        return cur;
    }
}