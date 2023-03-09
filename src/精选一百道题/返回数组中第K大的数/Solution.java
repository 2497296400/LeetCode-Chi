package 精选一百道题.返回数组中第K大的数;


import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(nums, 4));
     //   System.out.println(Arrays.toString(nums));
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, nums.length-k, 0, nums.length - 1);
    }

    private int quickSort(int[] nums, int key, int left, int right) {
        if(left==right){
            return nums[left];
        }
        int[] povit = findPovit(nums, left, right);

        if(povit[0]<=key&&key<=povit[1]){
            return nums[povit[0]];
        }
        if(key<povit[0]){
            return quickSort(nums,key,left,povit[0]-1);
        }else {
            return quickSort(nums,key,povit[1]+1,right);
        }
    }

    private int[] findPovit(int[] arr, int left, int right) {
        int curMin = left - 1;
        int curMax = right;
        int curIndex = arr[right];
        while (left < curMax) {
            if (arr[left] < curIndex) {
                swap(arr, ++curMin, left++);
            } else if (arr[left] > curIndex) {
                swap(arr, --curMax, left);
            } else {
                left++;
            }
        }
        swap(arr,curMax,right);
        return new int[]{curMin + 1, curMax};
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }


}
