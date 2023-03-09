package 滑动窗口.找到字符串中所有字母异位词;

import java.util.Arrays;

public class Dome {
    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "abab";
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 2, 3};
        String s2 = "ab";
        System.out.println(s.findAnagrams(s1, s2));
    }
}
