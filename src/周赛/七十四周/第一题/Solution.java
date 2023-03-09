package 周赛.七十四周.第一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int []num={3,4,9,1,3,9,5};
        System.out.println(findKDistantIndices(num,9,1));
    }
    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int targe = 0;
        List<Integer> list = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                arr.add(i);
            }
        }

            for (int i = 0; i < nums.length; i++) {
                for (var temp : arr) {
                    if (Math.abs(i - temp) <= k) {
                        list.add(i);
                        break;
                    }
                }
            }
        return list;
    }
}