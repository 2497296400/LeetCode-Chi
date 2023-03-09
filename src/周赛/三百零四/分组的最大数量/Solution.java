package 周赛.三百零四.分组的最大数量;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int []nums={2,31,41,31,36,46,33,45,47,8,31,6,12,12,15,35};
        System.out.println(solution.maximumGroups(nums));
    }
    public int maximumGroups(int[] grades) {
        if(grades.length<=2){
            return 1;
        }
        Arrays.sort(grades);
        int len = grades.length;
        int time = 0;
        int curMax=0;
        for(int i=1;i<=grades.length;i++){
            if(curMax>=grades.length){
                break;
            }
            curMax+=i;
            if(curMax<=grades.length){
            time++;
        }}
        return time;

    }
}