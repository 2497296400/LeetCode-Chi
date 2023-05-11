package 灵神总结周赛.图论.图中最长环;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ar = {3, 3, 4, 2, 3};
        System.out.println(solution.longestCycle(ar));
    }

    public int longestCycle(int[] edges) {
        int ans = -1;
        int[] time = new int[edges.length];
        int clock = 1;
        for (int i = 0; i < edges.length; i++) {
            if (time[i] > 0) continue;
            int start = clock;
            for (int x = i; x >= 0; x = edges[x]) {
                if (time[x] != 0) {
                    if (time[x] >= start) {
                        ans = Math.max(ans, clock-time[x]);
                    }
                    break;
                }
                time[x] = clock++;
            }
        }
        return ans;
    }
}
