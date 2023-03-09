package 每日一题系列.每日一题七月.下一个更大元素III;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().nextGreaterElement(12443322));
    }
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        Integer[] nums = new Integer[s.length()];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[len] = Integer.parseInt(String.valueOf(s.charAt(len)));
            len++;
        }
        int max=0;
        int cur = nums.length-2;
        while (cur>=0&&nums[cur]>=nums[cur+1]){
            cur--;
        }
        int index=nums.length-1;
        if(cur>=0) {
            while (index >= 0 && nums[cur] >= nums[index]) {
                index--;
            }
            swap(nums, cur, index);
        }
        reverse(nums,cur+1);
        for (int i=0;i<len;i++){
            max=max*10+nums[i];
        }
        return max>n?max:-1;
    }
    private void reverse(Integer[] nums, int left) {
        int right=nums.length-1;
        while (left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }

    private void swap(Integer[] nums, int cur, int index) {
        int temp=nums[cur];
        nums[cur]=nums[index];
        nums[index]=temp;
    }
}