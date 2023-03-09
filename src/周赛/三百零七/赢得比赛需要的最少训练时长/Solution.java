package 周赛.三百零七.赢得比赛需要的最少训练时长;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] e = {1, 4, 3, 2};
        int[] p = {2, 6, 3, 1};
        System.out.println(solution.minNumberOfHours(5, 3, e, p));
    }

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int cur = 0;
        for (int i = 0; i < energy.length; i++) {
            int second = experience[i];
            if (initialExperience > second) {
                initialExperience += second;
            } else {
                int curSum = second - initialExperience + 1;
                cur += curSum;
                initialExperience += curSum + second;
            }
        }
        int sum = 1;
        for (int i = 0; i < energy.length; i++) {
            sum += energy[i];
        }
        cur += Math.max((sum - initialEnergy), 0);
        return cur;
    }
}
