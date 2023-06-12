package 每日一题系列.每日一题五月.受标签影响的最大值;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestValsFromLabels(new int[]{2, 6, 1, 2, 6}, new int[]{2, 2, 2, 1, 1}, 1, 1));
    }
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int[][] arr = new int[values.length][2];
        for (int i = 0; i < values.length; i++) {
            arr[i][0] = values[i];
            arr[i][1] = labels[i];
        }
        Arrays.sort(arr, (o1, o2) -> o2[0] - o1[0]);
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < values.length; i++) {
            map.put(arr[i][1], map.getOrDefault(arr[i][1], 0) + 1);
            if (map.get(arr[i][1]) <= useLimit) {
                ans += arr[i][0];
                numWanted--;
            }
            if (numWanted == 0) {
                return ans;
            }
        }
        return ans;
    }
}
