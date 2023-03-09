package 括号问题.最长括号深度;

import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String s="(1)+((2))+(((3)))";
        System.out.println(maxDepth(s));
    }
    public static int maxDepth(String s) {
        int n=s.length();
        int leftless=0;
        int max=0;

        for(int i=0;i<n;i++){
             max = Math.max(max, leftless);
            if(s.charAt(i)=='('){
                leftless++;
            }
            if(s.charAt(i)==')'){
                leftless--;
            }
        }
        return max;

    }
}
