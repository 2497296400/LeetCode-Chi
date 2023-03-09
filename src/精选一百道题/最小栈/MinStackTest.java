package 精选一百道题.最小栈;

import java.util.Stack;

public class MinStackTest {
    class MinStack {
        public Stack<Integer> stack;

        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(val);
                stack.push(val);
            } else {

                int temp = stack.peek();
                stack.push(val);
                if (temp < val) {
                    stack.push(temp);
                }
                else {
                    stack.push(val);
                }
            }
        }
            public void pop () {
                stack.pop();
                stack.pop();
            }

            public int top () {
               return stack.get(stack.size()-2);
            }

            public int getMin () {
                return stack.peek();
            }
        }
    }
