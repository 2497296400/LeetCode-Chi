package 周赛.三百零五场周赛.算术三元组的数目;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
     TreeSet<Integer>set=new TreeSet<>();
     int len=0;
        for (int num : nums) {
            set.add(num);
        }
        for (Integer integer : set) {
            int curTemp=integer+diff;
            if(set.contains(curTemp)){
                curTemp+=diff;
                if(set.contains(curTemp)){
                    len++;
                }
            }
        }
        return len;
    }
}
