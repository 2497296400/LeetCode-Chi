package 每日一题系列.每日一题四月.最大子数组和;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Solution {
    int max = Integer.MIN_VALUE;
    static StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        int n = getInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = getInt();
        }
        System.out.println(solution.maxSubArray(arr));
    }

    public static int getInt() throws IOException {
        tokenizer.nextToken();
        return (int) tokenizer.nval;
    }

    public int maxSubArray(int[] nums) throws IOException {
        fun(nums, nums.length - 1);
        return max;

    }

    private int fun(int[] nums, int index) {
        if (index < 0) {
            return 0;
        }
        int cur = Integer.MIN_VALUE;
        int next = fun(nums, index - 1);
        //System.out.println(next);
        if (next >= 0) {
            cur = Math.max(cur, next + nums[index]);
        } else {
            cur = nums[index];
        }
        max = Math.max(max, cur);
        return cur;
    }
}
