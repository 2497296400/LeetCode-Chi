package 灵神总结周赛.技巧.商店的最少代价;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.bestClosingTime("YYYY"));
    }
    public int bestClosingTime(String customers) {
        int index = 0;
        char[] chars = customers.toCharArray();
        int n = chars.length;
        int[] arr = new int[n+1];
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = arr[i + 1] + (chars[i] == 'Y' ? 1 : 0);
        }
        int curMin = arr[0];
        int preCost = 0;
        for (int i = 0; i < chars.length; i++) {
            preCost += chars[i] == 'N' ? 1 : 0;
            int curCost = preCost + arr[i + 1];
            if (curCost < curMin) {
                curMin = curCost;
                index = i+1;
            }
        }
        return index;
    }
}
