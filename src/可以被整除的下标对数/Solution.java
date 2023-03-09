package 可以被整除的下标对数;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    final static int mx = 100001;
    static ArrayList<ArrayList<Integer>> divisors = new ArrayList<>(mx);
    static HashMap<Integer, ArrayList<Integer>> hasm = new HashMap<Integer, ArrayList<Integer>>();

    static {
        for (var i = 0; i < mx; i++) {
            divisors.add(new ArrayList<>());
            hasm.put(i, new ArrayList<>());
        }
        for (var i = 1; i < mx; ++i) {
            for (var j = i; j < mx; j += i) {
                divisors.get(j).add(i);
                hasm.get(j).add(i);
            }
        }
    }
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public long coutPairs(int[] nums, int k) {
        var ans = 0;
        var cnt = new HashMap<Integer, Integer>();
        for (var v : nums) {
            ans += cnt.getOrDefault(k / gcd(v, k), 0);
            for (var d : hasm.get(v)) {
                cnt.put(d, cnt.getOrDefault(d,0)+1);
            }
        }
        return ans;
    }
}
