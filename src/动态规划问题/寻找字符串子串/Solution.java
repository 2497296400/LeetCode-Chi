package 动态规划问题.寻找字符串子串;

import java.util.Arrays;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int plen=s1.length();
        int tlen=s2.length();
        int []pFrep=new int [26];
        int []winFrep=new int [26];
        for(int i=0;i<plen;i++){
        pFrep[s1.charAt(i)-'a']++;
        winFrep[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(winFrep, pFrep)){
            return true;
        }
        for(int i=plen;i<tlen;i++){
            winFrep[s2.charAt(i)-'a']++;
            winFrep[s2.charAt(i-plen)-'a']--;
            if(Arrays.equals(pFrep,winFrep)){
                return true;
            }
        }
        return false;
    }

}
