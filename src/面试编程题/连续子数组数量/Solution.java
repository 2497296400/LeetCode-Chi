package 面试编程题.连续子数组数量;

import java.util.List;

public class Solution {
    int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list = List.of(5, 2, 3, 50, 4);
        System.out.println(solution.getSubarrayNum(list, 2));
    }

    public int getSubarrayNum(List<Integer> a, int x) {
        // write code here
        long ans = 0L;
        int tow = 0;
        int five = 0;
        int l = 0;
        int r = 0;
        while (r < a.size()) {
            tow += getTow(a.get(r));
            five += getFive(a.get(r));
            r++;
            if (tow >= x && five >= x) {
                while (tow >= x && five >= x) {
                    tow -= getTow(a.get(l));
                    five -= getFive(a.get(l));
                    l++;
                    ans+=(a.size()-r+1);
                }
            }
        }
        return (int) (ans % MOD);
    }

    private int getTow(Integer integer) {
        int sum = 0;
        while (integer % 2 == 0) {
            sum++;
            integer /= 2;
        }
        return sum;
    }

    private int getFive(Integer integer) {
        int sum = 0;
        while (integer % 5 == 0) {
            sum++;
            integer /= 5;
        }
        return sum;
    }
}
