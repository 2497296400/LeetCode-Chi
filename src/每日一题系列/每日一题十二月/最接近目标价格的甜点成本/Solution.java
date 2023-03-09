package 每日一题系列.每日一题十二月.最接近目标价格的甜点成本;

public class Solution {
    int target;
    int ans;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        this.target = target;
        this.ans = Integer.MAX_VALUE;
        for (int baseCost : baseCosts) {
            dfs(baseCost, toppingCosts, 0);
        }
        return ans;
    }
    private void dfs(int baseCost, int[] toppingCosts, int cur) {
        if (cur == toppingCosts.length) {
            ans = Math.abs(target - baseCost) < Math.abs(target - ans) ? baseCost : ans;
            if (Math.abs(target - baseCost) == Math.abs(target - ans)) {
                ans = Math.min(ans, baseCost);
            }
            return;
        }
        for (int i = 0; i < 3; i++) {
            dfs(baseCost + toppingCosts[cur] * i, toppingCosts, cur + 1);
        }
    }
}
