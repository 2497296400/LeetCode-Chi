package 周赛.三百一十六场.判断两个事件是否存在冲突;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String [] s1={"01:15","02:00"};
        String []s2={"02:00","03:00"};
        System.out.println(solution.haveConflict(s1, s2));
    }
    public boolean haveConflict(String[] event1, String[] event2) {
        String f = event1[0];
        String s = event1[1];
        String ff = event2[0];
        String ss = event2[1];
        if (f.compareTo(ss) > 0) {
            return false;
        }
        if (s.compareTo(ff) < 0) {
            return false;
        }
        return true;
    }
}
