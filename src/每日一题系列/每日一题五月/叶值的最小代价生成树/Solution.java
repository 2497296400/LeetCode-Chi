package 每日一题系列.每日一题五月.叶值的最小代价生成树;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mctFromLeafValues(new int[]{14,8,7,5,4,8,5,9,9,2,11,3,5,13,3,14,8}));
    }

    public int mctFromLeafValues(int[] arr) {
        int[][] max = new int[arr.length][2];
        int leftMax = arr[0];
        int rightMax = arr[arr.length - 1];
        return getMin(0, arr.length - 1, arr, new HashMap<String, Integer>()) - Arrays.stream(arr).sum();
    }

    private int getMin(int l, int r, int[] arr, HashMap<String, Integer> stringIntegerHashMap) {
        if (l >= r) {
            return getMax(l, r, arr);
        }
        String key = l + "-" + r;
        if(stringIntegerHashMap.containsKey(key)){
           // System.out.println(key);
            return stringIntegerHashMap.get(key);
        }
        int curAns = Integer.MAX_VALUE;
        for (int i = l; i < r; i++) {
            int left = getMin(l, i, arr, stringIntegerHashMap);
            int right = getMin(i + 1, r, arr, stringIntegerHashMap);
            //System.out.println(left + " " + right);
            curAns = Math.min(curAns, left + right + getMax(l, r, arr));
        }
        stringIntegerHashMap.put(key, curAns);
        return curAns;
    }

    private int getMax(int l, int r, int[] arr) {
        //System.out.println(l + " " + r);
        if (l >= r) {
            return arr[r];
        }
        int[] leftMax = new int[r - l + 1];
        int[] rightMax = new int[r - l + 1];
        leftMax[0] = arr[l];
        rightMax[r - l] = arr[r];
        for (int i = l + 1; i <= r; i++) {
            leftMax[i - l] = Math.max(leftMax[i - l - 1], arr[i]);
        }
        for (int i = r - 1; i >= l; i--) {
            rightMax[i - l] = Math.max(rightMax[i - l + 1], arr[i]);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < r - l; i++) {
            ans = Math.max(ans, leftMax[i] * rightMax[i + 1]);
        }
        return ans;
    }
}
