package 汉诺塔.当前在汉诺塔最优解的第几部;

public class Solution {
    public int best(int[] arr) {
        return fun(arr, arr.length - 1, 1, 3, 2);
    }

    private int fun(int[] arr, int index, int from, int to, int other) {
        if (index < 0) {
            return 0;
        }
        if (arr[index] == other) {
            return -1;
        }
        if (arr[index] == from) {
            return fun(arr, index - 1, from, other, to);
        }
        int p1 = (1 << index)-1;
        int p2 = 1;
        int p3 = fun(arr, index - 1, other, to, from);
        if (p3 == -1) {
            return -1;
        }
        return p2 + p1 + p3;
    }
}
