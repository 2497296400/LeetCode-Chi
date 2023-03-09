package 括号问题.使括号有效的最少添加;

public class Solution {
    public static void main(String[] args) {
        String s="())";
        System.out.println(minAddToMakeValid(s));
    }
    public static int minAddToMakeValid(String s) {
    int n=s.length();
    int leftrest=0;
    int rightneed=0;
    for(int i=0;i<n;i++){
        if(s.charAt(i)=='('){
            leftrest++;
        }
        else {
            if(leftrest==0){
                rightneed++;
            }
            else {
                leftrest--;
            }
        }
    }
    return  leftrest+rightneed;
    }
}
