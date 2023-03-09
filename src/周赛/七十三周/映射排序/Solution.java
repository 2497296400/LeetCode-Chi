package 周赛.七十三周.映射排序;

import java.util.Arrays;
import java.util.Comparator;

//将杂乱无章的数字排序
class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[] res = new int[nums.length];
        int[][] temp = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            temp[i][0] = nums[i];
            temp[i][1] = convert(mapping, nums[i]);
        }
        // Arrays.sort(temp, (e1, e2) -> (e1[1] - e2[1]));
        Arrays.sort(temp, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[1] - o2[1];
                    }
                }
        );
        for (int i = 0; i < nums.length; i++) {
            res[i] = temp[i][0];
        }
        return res;
    }

    public int convert(int[] mapping, int val) {
        int dig = 1;
        int ret = 0;
        if (val <= 9) {
            return mapping[val];
        }
        while (val > 0) {
            ret += mapping[val % 10] * dig;
            dig *= 10;
            val /= 10;
        }
        return ret;
    }
}