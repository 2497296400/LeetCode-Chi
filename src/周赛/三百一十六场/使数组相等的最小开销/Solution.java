package 周赛.三百一十六场.使数组相等的最小开销;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 3, 5, 2};
        int[] cost = {2, 3, 1, 14};
        System.out.println(solution.minCost(arr, cost));
    }

    public long minCost(int[] nums, int[] cost) {
        Integer[] index = new Integer[nums.length];
        ArrayList<Data> arrayList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            arrayList.add(new Data(nums[i], cost[i]));
        }
        arrayList.sort((o1, o2) -> o1.tar - o2.tar);
        long min = 0, curr = 0, sum = 0;
        for (int i : cost) {
            sum += i;
        }
        int flag = arrayList.size();
        for (int i = 0; i < arrayList.size(); i++) {
            curr += arrayList.get(i).cos;
            if (curr >= sum / 2) {
                flag = i;
                break;
            }
        }
        long ans = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            ans += (long) Math.abs(arrayList.get(i).tar - arrayList.get(flag).tar) * arrayList.get(i).cos;
        }
        return ans;
    }
}

class Data {
    int tar;
    int cos;

    public Data(int tar, int cos) {
        this.tar = tar;
        this.cos = cos;
    }
}