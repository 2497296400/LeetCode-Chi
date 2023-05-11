package 灵神总结周赛.技巧.礼盒的最大甜蜜度;

import java.util.Arrays;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] p = {13, 5, 1, 8, 21, 2};
        System.out.println(solution.maximumTastiness(p, 3));
    }

    public int maximumTastiness(int[] price, int k) {
        int max = Arrays.stream(price).max().getAsInt();
        int l = 0, r = max;
        int ans = max;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : price) {
            set.add(i);

        }
        while (l < r) {
            int mid = (l + r) / 2;
            if (toCheck(mid, set, k)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return ans;
    }

    private boolean toCheck(int mid, TreeSet<Integer> set, int k) {
        Integer first = set.first();
        for (int i = 0; i < k-1; i++) {
            Integer ceiling = set.ceiling(first + mid);
            if (ceiling == null) {
                return false;
            }
            first = ceiling;
        }
        return true;
    }
}
