package 每日一题系列.每日一题七月.黑名单中的随机数;

import java.util.*;

public class Solution {
  private   Random ans=new Random();
   private Map<Integer, Integer>bw=new HashMap<>();
    private  int len;
    public Solution(int n, int[] blacklist) {
        len=n-blacklist.length;
        int index=len;
        Set<Integer> b =new HashSet<>();
        for (int i : blacklist) {
            if(i>=len){
                b.add(i);
            }
        }
        for (int i : blacklist) {
            if(i<len){
                while (b.contains(index++)){
                }
                bw.put(i,index++);
            }
        }
    }
    public int pick() {
        int temp=ans.nextInt(len);
        return bw.getOrDefault(temp,temp);
    }

    public static void main(String[] args) {
        int []bla={2, 3, 5};
        Solution s=new Solution(7,bla);
        for (int i = 0; i <100 ; i++) {
            System.out.println(s.pick());
        }
    }
}
