package 每日一题系列.每日一题八月.验证栈序列;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Stack<Integer>stack=new Stack<>();
        for (int i : popped) {
            queue.add(i);
        }
        for (int i : pushed) {
            stack.add(i);
            while (!stack.isEmpty()&&!queue.isEmpty()&&stack.peek().equals(queue.peek())){
                stack.pop();
                queue.poll();
            }
        }
        return stack.isEmpty()&&queue.isEmpty();
    }
}
