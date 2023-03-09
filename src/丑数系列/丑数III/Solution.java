package 丑数系列.丑数III;

import java.security.Key;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(4, 2, 3, 3));
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        long a_b = commonMultiple(a, b), a_c = commonMultiple(a, c), b_c = commonMultiple(b, c);
        long a_b_c = commonMultiple(a_b, a_c);
        long l = 0, r = 2000000001;
        while (l < r) {
            long mid = (l + r) / 2;
            if (mid / a + mid / b + mid / c - mid / a_b - mid / a_c - mid / b_c + mid / a_b_c < n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return (int) l;
    }

    private long commonMultiple(long a, long b) {
        if (a < b) return commonMultiple(b, a);
        long multi_a = a, multi_b = b;
        long c;

        while ((c = a % b) != 0) {
            a = b;
            b = c;
        }
        // 防止a*b溢出
        return multi_a / b * multi_b;
    }
}
