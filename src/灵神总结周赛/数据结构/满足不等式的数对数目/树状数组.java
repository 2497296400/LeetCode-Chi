package 灵神总结周赛.数据结构.满足不等式的数对数目;

import java.util.Arrays;

public class 树状数组 {
    public static void main(String[] args) {
        树状数组 树状数组 = new 树状数组();
        int[] arr = {3,2,5};
        int[] srr = {2,2,1};
        System.out.println(树状数组.numberOfPairs(arr, srr, 1));
    }

    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nums1[i] - nums2[i];
        }
        int[] array = Arrays.stream(nums1).distinct().sorted().toArray();
        int N = array.length;
        tree = new int[N + 1];
        long ans = 0L;
        for (int i : nums1) {
            int f = lowerBound2(array, i + diff + 1);
            int ff = lowerBound(array, i + diff + 1);
            ans += query(f);
            int ss = lowerBound(array, i);
            int s = lowerBound2(array, i);
            System.out.println(f + "  " + s + " ----" + ff + "  " + ss);
            add(1, s + 1);
        }
        return ans;
    }

    private int lowerBound(int[] array, int i) {
        int l = 0, r = array.length - 1;
        int folat = array.length;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (array[mid] < i) {
                l = mid + 1;
            } else {
                folat = mid;
                r = mid - 1;
            }
            //System.out.println(folat);
        }
        return folat;
    }

    private int lowerBound2(int[] array, int i) {
        int l = 0, r = array.length - 1;
        int folat = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (array[mid] < i) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        //System.out.println(l);
        return l;
    }

    int[] tree;
    int N;

    public int lowBit(int i) {
        return i & (-i);
    }

    public void add(int target, int index) {
        while (index < tree.length) {
            tree[index] += target;
            index += lowBit(index);
        }
    }

    public int query(int index) {
        int cur = 0;
        while (index > 0) {
            cur += tree[index];
            index -= lowBit(index);
        }
        return cur;
    }
}
