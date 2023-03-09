package 每日一题系列.每日一题八月.最多能完成排序的块II;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5,1,1,8,1,6,5,9,7,8};
        System.out.println(solution.maxChunksToSorted(nums));
    }
    private int curMin;
    public int maxChunksToSorted(int[] arr) {
        int sum = 0;
        int index = 0;
        while (index < arr.length) {
            HashMap<Integer, ArrayList<Integer>> map = toFinMin(index, arr);
            if (map.size() > 1) {
                sum++;
            } else {
                sum += map.get(curMin).size();
            }
            ArrayList<Integer> list = map.get(curMin);
            index = list.get(list.size() - 1);
            index++;
        }
        return sum;
    }
    private HashMap<Integer, ArrayList<Integer>> toFinMin(int index, int[] arr) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int min;
        int curIndex = index;
        curMin = arr[index];
        int curIndexData = arr[index];
        int curMax = 0;
        for (int i = index + 1; i < arr.length; i++) {
            curMax = Math.max(curMax, arr[i]);
            if (curIndexData > arr[i]) {
                min = arr[i];
                curMin = min;
                curIndex = i;
                curIndexData=Math.max(curMax,curIndexData);
            }
        }
        for (int i = index; i <= curIndex; i++) {
            if (!map.containsKey(arr[i])) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(i);
                map.put(arr[i], arrayList);
            } else {
                map.get(arr[i]).add(i);
            }
        }
        return map;
    }
}
