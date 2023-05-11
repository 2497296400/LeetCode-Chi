package 周赛.三百三十九场.第二题;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = new int[nums.length + 1];
        for (int num : nums) {
            arr[num]++;
        }
        while (true) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    temp.add(i);
                    arr[i]--;
                }
            }
            if (temp.isEmpty()) {
                return ans;
            }
            ans.add(new ArrayList<>(temp));
        }
    }
}
