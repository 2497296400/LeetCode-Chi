package 每日一题系列.每日一题一月.具有给定数值的最小字符串;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getSmallestString(3, 27));
    }
    public String getSmallestString(int n, int k) {
        Deque<Character> queue = new LinkedList<>();
        int curLen = 0;
        while (k > 26) {
            if (k > (n - 1) - curLen + 26) {
                curLen++;
                queue.addFirst('z');
                k -= 26;
            }else {
                break;
            }
        }
        int cur = k - (n - 1 - curLen);
        queue.addFirst((char) ('a' + cur-1));
        for (int i = 0; i < n - 1 - curLen;i++) {
            queue.addFirst('a');
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            stringBuilder.append(queue.poll());
        }
        return String.valueOf(stringBuilder);
    }
}
