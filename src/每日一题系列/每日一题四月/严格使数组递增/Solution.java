package 每日一题系列.每日一题四月.严格使数组递增;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {1, 5, 3, 6, 7};
        int[] arr2 = {1,6,3,3};
        System.out.println(solution.makeArrayIncreasing(arr1, arr2));
    }

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        Map<Integer, Integer>[] map = new Map[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            map[i] = new HashMap<>();
        }
        int fun = fun(arr1, arr2, 0, -1, map);
        return fun < Integer.MAX_VALUE / 2 ? fun : -1;
    }


    private int fun(int[] arr1, int[] arr2, int curIndex, int pre, Map<Integer, Integer>[] map) {
        if (curIndex == arr1.length) {
            return 0;
        }
        if (map[curIndex].containsKey(pre)) {
            return map[curIndex].get(pre);
        }
        int p1 = Integer.MAX_VALUE / 2;
        int mid = getMid(arr2, pre);
        if (mid != -1) {
            p1 = fun(arr1, arr2, curIndex + 1, arr2[mid], map) + 1;
        }
        if (arr1[curIndex] > pre) {
            p1 = Math.min(p1, fun(arr1, arr2, curIndex + 1, arr1[curIndex], map));
        }
        map[curIndex].put(pre, p1);
        return p1;
    }

    private int getMid(int[] arr2, int pre) {
        int l = 0, r = arr2.length;
        int pos = -1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr2[mid] <= pre) {
                l = mid + 1;
            } else {
                r = mid ;
                pos = mid;
            }
        }
        return pos;
    }
}
    