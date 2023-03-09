package 左神算法集.点灯问题.无环点灯;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 0, 1};
        Solution solution = new Solution();
        System.out.println(solution.lightMin(arr));
    }

    public int lightMin(int[] arr) {
        if (arr.length == 1) {
            return arr[0] ^ 1;
        }
        if (arr.length == 2) {
            return (arr[0] ^ arr[1]) == 0 ? 1 : -1;
        }
        int pi = fun(arr, 2, arr[0], arr[1]);
        int p2 = fun(arr, 2, arr[0] ^ 1, arr[1] ^ 1);
        if (p2 != -1) {
            p2++;
        }
        if (pi != -1 && p2 != -1) {
            return Math.min(pi, p2);
        } else {
            return pi == -1 ? p2 : pi;
        }
    }

    private int fun(int[] arr, int next, int preS, int curS) {
        if (next == arr.length) {
            return preS == curS ? (curS == 0 ? 1 : 0) : -1;
        }
        //一定点灯
        if (preS == 0) {
            curS ^= 1;
            int p1 = fun(arr, next + 1, curS, arr[next] ^ 1);
            return p1 == -1 ? -1 : p1 + 1;
        } else {
            return fun(arr, next + 1, curS, arr[next]);
        }
    }
}
