package 周赛.三百一十场.出现最频繁的偶数元素;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int num : nums) {
            if (num % 2 == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        int cur = -1;
        int va = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > va) {
                cur = entry.getKey();
                va = entry.getValue();
            }else if(entry.getValue()==va&&cur>entry.getKey()){
                cur = entry.getKey();
            }
        }
        return cur;
    }
}
