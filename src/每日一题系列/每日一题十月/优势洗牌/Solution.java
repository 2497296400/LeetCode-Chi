package 每日一题系列.每日一题十月.优势洗牌;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {12, 24, 8, 32};
        int[] arr1 = {13, 25, 32, 11};
        System.out.println(Arrays.toString(solution.advantageCount(arr, arr1)));
    }

    public int[] advantageCount(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> set = new TreeMap<>();
        for (int i : nums1) {
            set.put(i, set.getOrDefault(i, 0) + 1);
        }
        for (int i = 0; i < nums1.length; i++) {
            Integer integer = set.ceilingKey(nums2[i] + 1);
            if (integer == null) {
                integer = set.firstKey();

            }
            nums1[i] = integer;
            if (set.get(integer) == 1) {
                set.remove(integer);
            } else {
                set.put(integer, set.get(integer) - 1);
            }
        }
        return nums1;
    }
}
