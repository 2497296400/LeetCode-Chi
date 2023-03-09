package 每日一题系列.每日一题二月.循环码排列;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.circularPermutation(2, 3));
    }

    List<Integer> ans;

    public List<Integer> circularPermutation(int n, int start) {
        ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(start);
        set.add(start);
        fun(n, start, stack);

        return ans;
    }

    Set<Integer> set = new HashSet<>();

    private boolean fun(int n, int start, Stack<Integer> stack) {
        if (stack.size() == Math.pow(2, n)) {
            ans = new ArrayList<>(stack);
            return true;
        }
        for (int i = 0; i < n; i++) {
            int cur = start ^ (1 << i);
            if (set.contains(cur)) {
                continue;
            }
            stack.add(cur);
            set.add(cur);
            if (fun(n, cur, stack)) {
                return true;
            }
            stack.pop();
            set.remove(cur);
        }
        return false;
    }
}
