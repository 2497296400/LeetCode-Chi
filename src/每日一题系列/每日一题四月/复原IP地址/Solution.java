package 每日一题系列.每日一题四月.复原IP地址;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.restoreIpAddresses("28576"));
    }

    public List<String> restoreIpAddresses(String s) {
        Stack<String> temp = new Stack<>();
        List<String> ans = new ArrayList<>();
        fun(s, 0, ans, temp);
        return ans;
    }

    private void fun(String s, int start, List<String> ans, Stack<String> temp) {
        if (temp.size() == 4 && start == s.length()) {
            ans.add(String.join(".", temp));
            return;
        }
        for (int i = start; i < Math.min(start + 3, s.length()); i++) {
            String cur = s.substring(start, i + 1);
            if (!tocheck(cur)) {
                break;
            }
            //System.out.println(cur);
            temp.add(cur);
            fun(s, i + 1, ans, temp);
            //System.out.println(temp);
            temp.pop();
        }
    }

    private boolean tocheck(String cur) {
        char[] array = cur.toCharArray();
        if (array.length > 1) {
            if (array[0] == '0') {
                return false;
            }
            if (array.length == 3) {
                if (array[0] > '2') {
                    return false;
                }
                if (array[0] == '2') {
                    if (array[1] > '5') {
                        return false;
                    }
                    if (array[1] == '5') {
                        if (array[2] > '5') {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
