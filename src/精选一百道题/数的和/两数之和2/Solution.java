package 精选一百道题.数的和.两数之和2;
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int end=numbers.length-1;
        int start=0;
        while(start<end){
            int sum=(numbers[start]+numbers[end]);
            if(sum==target)return new int[]{start + 1, end + 1};
            if(sum>target){
                end--;
            }
            else {
                start++;
            }
        }
        return null;
    }
}