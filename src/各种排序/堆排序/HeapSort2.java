package 各种排序.堆排序;

import java.util.Arrays;

public class HeapSort2 {
    public static void main(String[] args) {
        int[] nums = {1, 5, 9, 0, 5};
        heapSort(nums);
    }

    public static void heapSort(int[] nums) {
        if (nums == null) {
            return;
        }
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            maxHpfiy(nums, i);
        }
        System.out.println(Arrays.toString(nums));
        while (size > 0) {
            hpfiy(nums, 0, size);
            System.out.println(Arrays.toString(nums));
            swap(nums, 0, --size);
        }
        System.out.println(Arrays.toString(nums));
    }
    private static void hpfiy(int[] nums, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int large = left + 1 < size && nums[left + 1] > nums[left] ? left + 1 : left;
            large = nums[large] > nums[index] ? large : index;
            if (large == index) {
                break;
            }
            swap(nums, index, large);
            index = large;
            left = index * 2 + 1;
        }
    }
    private static void maxHpfiy(int[] nums, int index) {
        while (nums[index] > nums[(index - 1) / 2]) {
            swap(nums, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void swap(int[] nums, int index, int i) {
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }

}
