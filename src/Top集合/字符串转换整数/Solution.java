package Top集合.字符串转换整数;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "   -42";
        System.out.println(solution.myAtoi(s));
    }

    public int myAtoi(String s) {
        String trim = s.trim();
        char[] sc = trim.toCharArray();
        int falg = 1;
        Queue<Character> queue = new LinkedList<>();
        int csum = 0;
        int len = 0;

        for (Character character : sc) {
            if (Character.isDigit(character)) {
                queue.add(character);
            } else if (character == '-') {
                if (len != 0) {
                    break;

                }
                falg = -1;
                csum++;
            } else if (character == '+') {

                if (len != 0) {
                    break;

                }
                falg = 1;
                csum++;
            } else {
                csum++;
                if (csum >= 2 && queue.isEmpty()) {
                    return 0;
                } else {
                    break;
                }
            }
            if (csum >= 2 && queue.isEmpty()) {
                return 0;
            }
            len++;

        }
        long ans = 0;
        while (!queue.isEmpty()) {
            ans = ans * 10 + (queue.poll() - '0');
            if (ans > Integer.MAX_VALUE) {
                ans = Integer.MAX_VALUE;
                if (falg == -1) {
                    ans++;
                }
                break;
            }
        }

        if (ans > Integer.MAX_VALUE) {
            ans = Integer.MAX_VALUE;
            if (falg == -1) {
                ans++;
            }
        }

        return (int) (ans * falg);
    }
}
