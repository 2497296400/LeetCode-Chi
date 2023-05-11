package 每日一题系列.每日一题四月.负二进制转换;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.baseNeg22(8));
    }
    public String baseNeg2(int n) {
        int target = 0;
        boolean[] vis = new boolean[32];
        int last = 0;
        for (int i = 0; i < 32; i += 2) {
            if (target >= n) {
                break;
            }
            target += Math.pow(2, i);
            vis[i] = true;
            last = i;
        }
        int less = target - n;
        if(less==0){
            return "0";
        }
        toCheck(less, vis, last);
        return toFun(vis);
    }

    private void toCheck(int less, boolean[] vis, int last) {
        if (less == 0) {
            return;
        }
        int ta = 0;
        int index = 0;
        for (int i = 0; i <= last; i++) {
            ta = (int) Math.pow(2, i);
            if (ta >= less) {
                if (ta == less) {
                    index = i;
                    break;
                } else {
                    ta = (int) Math.pow(2, i - 1);
                    index = i - 1;
                    break;
                }
            }
        }
        vis[index] = !vis[index];
        toCheck(less-ta, vis, last);
    }
    private String toFun(boolean[] vis) {
        Deque<Character> queue = new LinkedList<>();
        boolean isF = false;

        for (int i = 31; i >= 0; i--) {
            if (vis[i]) {
                isF = true;
            }
            if (isF) {
                queue.add(vis[i] ? '1' : '0');
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            stringBuilder.append(queue.pop());
        }
        return stringBuilder.toString();
    }

    public String baseNeg22(int n) {
        if (n == 0 || n == 1) {
            return String.valueOf(n);
        }
        StringBuilder res = new StringBuilder();
        while (n != 0) {
            int remainder = n & 1;
            res.append(remainder);
            n -= remainder;
            n /= -2;
        }
        return res.reverse().toString();
    }
    
}