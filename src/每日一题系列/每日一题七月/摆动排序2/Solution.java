package 每日一题系列.每日一题七月.摆动排序2;

import java.util.Arrays;
public class Solution {
    public static void main(String[] args) {
        int []nums={1,5,1,1,6,4};
        wiggleSort(nums);
    }
    public static void wiggleSort(int[] nums) {
      Arrays.sort(nums);
      int []ans=new int[nums.length];
      int len=1;
      int start=0;
      int end=nums.length-1;
      int curI=0;
      while (len<nums.length){
          ans[len]=nums[end--];
          len+=2;
      }
      while (curI<nums.length){
          ans[curI]=nums[end--];
          curI+=2;
      }
     int s=0;
        for (int an : ans) {
            nums[s++]=an;
        }
    }
}
