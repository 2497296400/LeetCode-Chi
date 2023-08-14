package 基础数据结构.大数求幂求余;

import java.util.Stack;

public class Solution {
    int MOD = 1025;

    public static void main(String[] args) {
        Solution solution = new Solution();
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(solution.superPow(2, stack));
        System.out.println(1024 * 64);
        System.out.println(solution.myPow2(2, 10));
    }

    public int superPow(int f, Stack<Integer> v) {
        if (v.isEmpty()) {
            return 1;
        }
        int last = v.pop();
        int ff = myPow2(f, last);
        int ss = myPow2(superPow(f, v), 10);
        return ff * ss;
    }

    private int myPow(int f, int last) {
        int ans = 1;
        f = f % MOD;
        for (int i = 0; i < last; i++) {
            ans = ans * f;
            ans = ans % MOD;
        }
        return ans;
    }

    private int myPow2(int f, int last) {
        if (last == 0) {
            return 1;
        }
        if (last % 2 == 0) {
            return myPow(f * f % MOD, last / 2);
        } else {
            return f * myPow2(f, last - 1) % MOD;
        }
        
    }
}
