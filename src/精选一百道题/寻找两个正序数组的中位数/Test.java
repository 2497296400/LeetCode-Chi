package 精选一百道题.寻找两个正序数组的中位数;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        int[] arr = {1, 3};
        int[] ss = {2,4};
        System.out.println(test.findMedianSortedArrays(arr, ss));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int first = (m + n + 1) / 2;
        int second = (m + n + 2) / 2;
        return (fun(nums1, 0, nums2, 0, first) + fun(nums1, 0, nums2, 0, second)) / 2.0;
    }

    private double fun(int[] nums1, int f, int[] nums2, int s, int curIndex) {
        if (f >= nums1.length) {
            return nums2[s + curIndex/2 - 1];
        }
        if (s >= nums2.length) {
            return nums1[f + curIndex/2 - 1];
        }
        if (curIndex == 1) {
            return Math.min(nums1[f], nums2[s]);
        }
        int fc = (f + curIndex / 2 - 1) < nums1.length ? nums1[f + curIndex / 2 - 1] : Integer.MAX_VALUE;
        int sc = (s + curIndex / 2 - 1) < nums2.length ? nums2[s + curIndex / 2 - 1] : Integer.MAX_VALUE;
        if (fc < sc) {
            return fun(nums1, f +  curIndex / 2, nums2, s, curIndex - curIndex / 2);
        } else {
            return fun(nums1, f, nums2, s + curIndex / 2, curIndex - curIndex / 2);
        }
    }
}
