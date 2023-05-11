package 灵神总结周赛.数据结构.元素值大于变化阈值的子数组;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 并查集 {
    int[] fa, size;

    public static void main(String[] args) {
        并查集 并查集 = new 并查集();
        int[] arr = {1, 3, 4, 3, 1};
        System.out.println(并查集.validSubarraySize(arr, 6));
    }

    public int validSubarraySize(int[] nums, int threshold) {
        int n = nums.length;
        fa = new int[n + 1];
        size = new int[n + 1];
        Arrays.fill(size, 1);
        for (int i = 0; i <= n; i++) {
            fa[i] = i;
        }
        Integer[] array = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        Arrays.sort(array, (i, j) -> {
            return nums[j] - nums[i];
        });
        for (Integer integer : array) {
            int next = find(integer + 1);
            fa[integer] = next;
            size[next] += size[integer];
            int curSize = size[next] - 1;
            if (nums[integer] > threshold / curSize) {
                return curSize;
            }
        }
        return -1;
    }

    public int find(int x) {
        if (fa[x] != x) {
            fa[x] = find(fa[x]);
        }
        return fa[x];
    }
}
