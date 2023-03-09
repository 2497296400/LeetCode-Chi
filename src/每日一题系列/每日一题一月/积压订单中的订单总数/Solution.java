package 每日一题系列.每日一题一月.积压订单中的订单总数;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
    private final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] or = {{7, 1000000000, 1}, {15, 3, 0}, {5, 999999995, 0}, {5, 1, 1}};
        System.out.println(solution.getNumberOfBacklogOrders(or));
    }
    public int getNumberOfBacklogOrders(int[][] orders) {
        TreeMap<Integer, Long> buy = new TreeMap<>((a, b) -> b - a);
        TreeMap<Integer, Long> sell = new TreeMap<>();

        for (int[] order : orders) {
            if (order[2] == 0) {
                int cur = order[0];
                long sum = order[1];
                Map.Entry<Integer, Long> firstEntry = sell.firstEntry();
                while (sum > 0 && firstEntry != null && firstEntry.getKey() <= cur) {
                    Long value = firstEntry.getValue();
                    if (sum >= value) {
                        sum -= value;
                        sell.remove(firstEntry.getKey());
                    } else {
                        value -= sum;
                        sum = 0;
                        sell.put(firstEntry.getKey(), value);
                    }
                    firstEntry = sell.firstEntry();
                }
                if (sum > 0) {
                    buy.put(order[0], buy.getOrDefault(order[0], 0L) + sum);
                }
            } else {
                int cur = order[0];
                long sum = order[1];
                Map.Entry<Integer, Long> firstEntry = buy.firstEntry();
                while (sum > 0 && firstEntry != null && firstEntry.getKey() >= cur) {
                    Long value = firstEntry.getValue();
                    if (sum >= value) {
                        sum -= value;
                        buy.remove(firstEntry.getKey());
                    } else {
                        value -= sum;
                        sum = 0;
                        buy.put(firstEntry.getKey(), value);
                    }
                    firstEntry = buy.firstEntry();
                }
                if (sum > 0) {
                    sell.put(order[0], sell.getOrDefault(order[0], 0L) + sum);
                }
            }
        }
        long ans = 0L;
        for (Long value : sell.values()) {
            ans += value;
        }
        for (Long value : buy.values()) {
            ans += value;
        }
        return (int) (ans % MOD);
    }
}