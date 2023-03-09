package 周赛.三百零二周赛.裁剪数字;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String[] nums = {"24", "37", "96", "04"};

        int[][] quer = {{2, 1}, {2, 2}};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.smallestTrimmedNumbers(nums, quer)));
    }

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        int len = 0;
        for (int[] query : queries) {
            String[] StirngTemp = new String[nums.length];
            int curTemplen = 0;
            for (String num : nums) {
                String substring = num.substring(num.length() - query[1]);
                StirngTemp[curTemplen++] = substring;
            }

            for (int i = 0; i < curTemplen; i++) {
                int temp = 0;
                for (int j = 0; j < curTemplen; j++) {
                    if (j != i) {
                        if (StirngTemp[j].compareTo(StirngTemp[i]) > 0) {
                            temp++;
                        }
                        if (StirngTemp[j].compareTo(StirngTemp[i]) == 0 && j > i) {
                            temp++;
                        }
                    }
                }
                if ((nums.length - temp) == (query[0])) {
                    ans[len++] = i;
                    break;
                }
            }
        }
        return ans;
    }
}
