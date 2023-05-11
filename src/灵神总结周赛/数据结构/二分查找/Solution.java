package 灵神总结周赛.数据结构.二分查找;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 5, 5, 6, 9, 9, 10, 111};
        System.out.println(lowerBound(arr, 1));
    }

    private static int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length-1;
        int flag = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] < target) {
                flag = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return flag;
    }
}
