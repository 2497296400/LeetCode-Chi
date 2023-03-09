package 双端队列求滑动窗口最大值;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaxArray {
    public static int[] getMaxWindow(int[] arr, int w) {
        Deque<Integer> deque = new ArrayDeque<>();
        if (arr == null || w < 1 || arr.length < w - 1) {
            return null;
        }
        int[] nums = new int[arr.length - w + 1];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (deque.peekFirst() == i - w) {
                deque.pollFirst();
            }
            if (i >= w - 1) {
                nums[idx++] = arr[deque.peekFirst()];
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nmus = {1, 3, 1, 2, 0, 5};
        System.out.println(Arrays.toString(getMaxWindow(nmus, 3)));
    }
}
