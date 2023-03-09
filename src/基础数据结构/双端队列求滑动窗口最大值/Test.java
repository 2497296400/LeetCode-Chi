package 基础数据结构.双端队列求滑动窗口最大值;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Test {
    public static void main(String[] args) {
        int[] arr = {7, 2, 4, 1, 5, 6, 1, 8, 69};
        Test test = new Test();
        System.out.println(Arrays.toString(test.get(arr, 4)));
    }

    public int[] get(int[] arr, int k) {
        int[] ans = new int[arr.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            if (i - k + 1 >= 0) {
                ans[i - k + 1] = arr[deque.peekFirst()];
            }
        }
        return ans;
    }
}
