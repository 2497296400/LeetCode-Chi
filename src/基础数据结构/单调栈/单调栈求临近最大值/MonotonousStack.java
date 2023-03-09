package 基础数据结构.单调栈.单调栈求临近最大值;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MonotonousStack {
    //无重复值
    public static int[][] getNearLessNoRepeat(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int popIndex = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
                res[popIndex][0] = leftLessIndex;
                res[popIndex][1] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int popIndex = stack.pop();  // 弹出栈顶元素
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
            res[popIndex][0] = leftLessIndex;
            res[popIndex][1] = -1;
        }
        return res;
    }

    //有重复数
    public static int[][] getNearLessRepeat(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<>();
        Stack<List<Integer>> stack1 = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] < arr[i]) {
                List<Integer> pop = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().
                        get(stack.peek().size() - 1);
                for (Integer integer : pop) {
                    res[integer][0] = leftLessIndex;
                    res[integer][1] = i;
                }
            }
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(i);
            } else {

                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        while (!stack.isEmpty()) {
            List<Integer> pop = stack.pop();
            int leftLessIndex = stack.isEmpty() ? 1 : stack.peek().
                    get(stack.peek().size() - 1);
            for (Integer integer : pop) {
                res[integer][0] = leftLessIndex;
                res[integer][1] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 15, 6, 7};
        int[][] res = getNearLessNoRepeat(arr);
        int[][] nearLessRepeat = getNearLessRepeat(arr);
        System.out.println(Arrays.deepToString(res));
        System.out.println(Arrays.deepToString(nearLessRepeat));
    }
}
