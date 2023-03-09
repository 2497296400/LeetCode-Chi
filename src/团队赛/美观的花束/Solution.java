package 团队赛.美观的花束;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(beautifulBouquet(new int[]{1, 2, 2, 2, 2, 2, 10442, 2
        }, 1));
    }

    public static int beautifulBouquet(int[] flowers, int cnt) {
        int MOD = (int) (1e9 + 7);
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int end = 0;
        int start = 0;
        long c = 0;
        while (end < flowers.length) {
            map.put(flowers[end], map.getOrDefault(flowers[end], 0) + 1);
            while (map.get(flowers[end]) > cnt) {
                map.put(flowers[start], map.get(flowers[start]) - 1);
                start++;
            }
            c += end - start + 1;
            end++;
        }
        return (int) c % MOD;
    }
}
