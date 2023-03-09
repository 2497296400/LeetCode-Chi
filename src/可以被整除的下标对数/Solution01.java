package 可以被整除的下标对数;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution01 {
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public long coutPairs(int[] nums, int k) {
        ArrayList<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= k; i++) {
            if (k % i == 0) {
                divisors.add(i);
                if (i * i < k) {
                    divisors.add(k / i);
                }
            }
        }
        var ans = 0L;
        var cnt = new HashMap<Integer, Integer>();
        for (var v : nums) {
            ans += cnt.getOrDefault(k / gcd(v, k), 0);
            for (var d : divisors) {
                if (v % d == 0) {
                    cnt.put(d, cnt.getOrDefault(d, 0) + 1);
                }
            }
        }
        return ans;
    }
}
