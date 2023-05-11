package 灵神总结周赛.技巧.所有数对的异或和;

public class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        if (nums1.length % 2 != 0 && nums2.length % 2 != 0) {
            int ans = 0;
            for (int i = 0; i < nums1.length; i++) {
                ans ^= nums1[i];
            }
            for (int i = 0; i < nums2.length; i++) {
                ans ^= nums2[i];
            }
            return ans;
        }
        if (nums1.length % 2 != 0) {
            int ans = 0;
            for (int i = 0; i < nums1.length; i++) {
                ans ^= nums1[i];
            }
            return ans;
        }
        if (nums2.length % 2 != 0) {
            int ans = 0;
            for (int i = 0; i < nums2.length; i++) {
                ans ^= nums2[i];
            }
            return ans;
        }
        return 0;
    }
}
