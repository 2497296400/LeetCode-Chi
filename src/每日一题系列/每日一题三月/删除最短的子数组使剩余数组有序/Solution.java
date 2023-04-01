package 每日一题系列.每日一题三月.删除最短的子数组使剩余数组有序;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findLengthOfShortestSubarray(new int[]{22, 37, 59, 16, 42, 32, 29, 53, 9, 55, 29, 3, 4, 1, 49, 17, 37, 31, 27, 45, 33, 24, 54, 51, 32, 51, 54, 31, 36, 53}));

    }

    public int findLengthOfShortestSubarray(int[] arr) {
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int pre = arr[i - 1];
            int cur = arr[i];
            if (cur < pre) {
                for (int curIndex = i - 1; curIndex >= -1; curIndex--) {
                    if (toGet(arr, curIndex) > ans) {
                        return ans;
                    }
                    ans = Math.min(ans, toGet(arr, curIndex));
                }
                return ans;
            }
        }
        return 0;
    }

    private int toGet(int[] arr, int curIndex) {
        int pre = Integer.MIN_VALUE;
        if (curIndex >= 0) {
            pre = arr[curIndex];
        }
        int las = Integer.MAX_VALUE;
        for (int i = arr.length - 1; i > curIndex; i--) {
            if (arr[i] < pre || arr[i] > las) {
                return i - curIndex;
            }
            las = arr[i];
        }
        return arr.length - curIndex - 1;
    }
}
