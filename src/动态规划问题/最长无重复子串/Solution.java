package 动态规划问题.最长无重复子串;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String str="abca";
        System.out.println(lengthOfLongestSubstring(str));
    }
    public static int lengthOfLongestSubstring(String s) {
        int strat=0;
        int max=0;
        int []last=new int[26];
        Arrays.fill(last,-1);
        for(int i=0;i<s.length();i++){
            int indx=s.charAt(i)-'a';
            if(indx>26||indx<0){
                break;
            }
            strat=Math.max(strat,last[indx]+1);
            max=Math.max(max,i-strat+1);
            last[indx]=i;
        }
        return max;
    }
}

