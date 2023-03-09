package 每日一题系列.每日一题九月.删除某些元素后的数组均值;

import java.util.Arrays;

public class Solution {
    public double trimMean(int[] arr) {
        int delete = arr.length / 20;
        Arrays.sort(arr);
        double sum = 0;
        for(int i = delete;i<arr.length-delete;i++){
            sum+=arr[i];
        }
        return sum/(arr.length-2*delete);

    }

}
