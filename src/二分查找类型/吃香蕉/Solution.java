package 二分查找类型.吃香蕉;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minEatingSpeed(new int[]{312884470
        }, 968709470));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int curMax = 0;
        for (int pile : piles) {
            curMax = Math.max(curMax, pile);
        }
        int l = 0;
        int r = curMax;
        while (l < r) {
            int mid = (l + r) / 2;
            int cur = 0;
            if(mid==0){
                return 1;
            }
            for (int pile : piles) {
                cur += (pile + mid - 1) / mid;
            }
            if (cur > h) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
}
