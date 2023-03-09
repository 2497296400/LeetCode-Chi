package 左神算法集.取第几小的数据;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 5, 9};
        int[] arr2 = {3, 9, 10};
        System.out.println(solution.getUpMin(arr, arr2, 0));
    }

    public int getUpMin(int[] arr1, int[] arr2, int toGet) {
        return fun(arr1, 0, arr1.length - 1, arr2, 0, arr2.length - 1);
    }

    private int fun(int[] arr1, int s1, int e1, int[] arr2, int s2, int e2) {
        int mid1 = 0;
        int mid2 = 0;
        while (s1 < e1) {
            mid1 = (s1 + e1) / 2;
            mid2 = (s2 + e2) / 2;
            if (arr1[mid1] == arr2[mid2]) {
                return arr2[mid2];
            }
            if ((e1 - s1 + 1) % 2 == 1) {
                if (arr1[mid1] > arr1[mid2]) {
                    if (arr2[mid2] >= arr1[mid1 - 1]) {
                        return arr2[mid2];
                    }
                    e1 = mid1 - 1;
                    s2 = mid2 + 1;
                } else {
                    if (arr1[mid1] >= arr2[mid2 - 1]) {
                        return arr1[mid1];
                    }
                    s1 = mid1 + 1;
                    e2 = mid2 - 1;
                }
            } else {
                if (arr1[mid1] > arr2[mid2]) {
                    e1 = mid1 - 1;
                    s2 = mid2;
                } else {
                    e2 = mid2 - 1;
                    s1 = mid1;
                }
            }
        }
        return Math.min(arr1[s1], arr2[s2]);

    }
}
