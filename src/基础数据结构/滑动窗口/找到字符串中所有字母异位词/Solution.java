package 滑动窗口.找到字符串中所有字母异位词;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>lists=new ArrayList<>();
            int slen=s.length();
            int plen=p.length();
            int []sFrep=new int [26];
            int []winFrep=new int [26];
            if(slen<plen){
                return lists;
            }
        for (int i = 0; i < plen; i++) {
            sFrep[s.charAt(i)-'a']++;
            winFrep[p.charAt(i)-'a']++;
        }
        if(Arrays.equals(sFrep,winFrep)){
            lists.add(0);
        }
        for(int j=plen,i=0;j<slen;j++,i++){
           sFrep[s.charAt(j)-'a']++;
           sFrep[s.charAt(i)-'a']--;
           if(Arrays.equals(sFrep,winFrep)){
               lists.add(i+1);
           }
        }
        return lists;
    }
}