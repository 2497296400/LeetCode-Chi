package 每日一题系列.每日一题八月.在既定时间做作业的学生人数;

public class Solution {
        public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
            int sum=0;
            int n=startTime.length;
            for (int i=0;i<n;i++){
                if(queryTime>=startTime[i]&&queryTime<=endTime[i]){
                    sum++;

                }
            }
            return sum;
        }
}
