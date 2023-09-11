package 动态规划难搞类.合并石子问题;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {5, 1, 1};
        System.out.println(solution.mergeStone(arr));
    }
    public int[] sum(int[] arr) {
        int[] sum = new int[arr.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];
        }
        return sum;
    }

    public int mergeStone(int[] arr) {
        int N = arr.length;
        int[] sum = sum(arr);
        return fun(0, N - 1, sum);
    }

    private int fun(int left, int right, int[] sum) {
        if (left == right) {
            return 0;
        }
        int next = Integer.MAX_VALUE;
        for (int cur = left; cur < right; cur++) {
            
            next = Math.min(next, fun(left, cur, sum) + fun(cur+1, right, sum)+ getSum(left, right, sum));
        }
        return next;
    }
    private int getSum(int left, int right, int[] sum) {
        return sum[right + 1] - sum[left];
    }
}
