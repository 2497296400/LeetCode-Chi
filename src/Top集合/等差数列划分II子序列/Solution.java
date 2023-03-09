package Top集合.等差数列划分II子序列;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] arr={2,4,6,8,10};
        System.out.println(solution.numberOfArithmeticSlices(arr));
    }
    public int numberOfArithmeticSlices(int[] nums) {
        List<HashMap<Integer, Integer>> maps = new ArrayList<>();
        long ans = 0L;
        for (int i = 0; i < nums.length; i++) {
            maps.add(new HashMap<>());
            for (int j = i - 1; j >= 0; j--) {
                long d = (long) nums[i] -(long) nums[j];
                if(d>Integer.MAX_VALUE||d<Integer.MIN_VALUE){
                    continue;
                }
                HashMap<Integer, Integer> s = maps.get(i);
                HashMap<Integer, Integer> f = maps.get(j);
                Integer integer = f.getOrDefault((int )d, 0);
                ans += integer;
                s.put((int) d, s.getOrDefault((int )d,0)+integer + 1);
            }
        }
        return (int) ans;
    }
}
