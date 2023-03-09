package 各种排序.快速排序;

import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 5, 3, 48, 9, 1, 6, 2, 3, 58, 74, 9, 6, 12, 69, 3, -1, -5};
        Sotr(arr, 2);
//        for (int i = 0; i < 10; i++) {
//            findTure();
//        }
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void findTure() {
        Random random = new Random();
        int i = random.nextInt(20);
        int[] nums = new int[i];
        for (int i1 = 0; i1 < nums.length; i1++) {
            nums[i1] = random.nextInt(20);
        }
        int anInt = nums[random.nextInt(nums.length)];
        Sotr(nums, anInt);
        System.out.println("Index" + "=" + anInt + " " + Arrays.toString(nums));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int[] position = getPrivot(arr, left, right);
            quickSort(arr, left, position[0] - 1);
            quickSort(arr, position[1] + 1, right);
        }
    }

    private static int[] getPrivot(int[] arr, int left, int right) {
        int less = left - 1;
        int more = right;
        int target = arr[right];
        while (left < more) {
            if (arr[left] < target) {
                swap(arr, ++less, left++);
            } else if (arr[left] > target) {
                swap(arr, --more, left);
            } else {
                left++;
            }
        }
        swap(arr, more, right);
        return new int[]{less + 1, more};
    }
    private static void Sotr(int[] arr, int index) {
        int left = 0;
        int curMin = -1;
        int curMax = arr.length;
        while (left < curMax) {
            if (arr[left] < index) {
                swap(arr, ++curMin, left++);
            } else if (arr[left] > index) {
                swap(arr, left, --curMax);
            } else {
                left++;
            }
        }
    }

    private static void swap(int[] arr, int cur, int next) {
        int temp = arr[cur];
        arr[cur] = arr[next];
        arr[next] = temp;
    }

}
