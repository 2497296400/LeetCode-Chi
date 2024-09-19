package 每日一题系列.每日一题八月.找出与数组相加的整数I;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {
      return   Arrays.stream(nums1).min().getAsInt()-Arrays.stream(nums2).min().getAsInt();
    }
}
