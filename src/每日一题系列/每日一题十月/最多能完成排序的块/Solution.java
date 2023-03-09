package 每日一题系列.每日一题十月.最多能完成排序的块;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,0,3};
        System.out.println(solution.maxChunksToSorted(arr));
    }

    public int maxChunksToSorted(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int curMax = arr[i];
            while (curMax > i) {
                curMax = Math.max(curMax, arr[++i]);
            }
            sum++;
        }
        return sum;
    }
}
