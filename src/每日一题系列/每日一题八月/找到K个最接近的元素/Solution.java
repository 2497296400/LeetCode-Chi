package 每日一题系列.每日一题八月.找到K个最接近的元素;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author pc
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,1,10,10,10};
        int []nums2={1,25,35,45,50,59};
        int []nums1={1,2};
        System.out.println(solution.findClosestElements(nums2, 1, 30));
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int curIndex = fun(arr, x);
        Deque<Integer> queue = new LinkedList<>();
        int pre;
        int next;
        if (arr[curIndex] == x) {

             pre = curIndex - 1;
             next = curIndex + 1;
            queue.add(arr[curIndex]);
        }else {
             pre=curIndex;
             next=curIndex+1;
        }
        while (queue.size() < k) {
            int curFirst = Integer.MAX_VALUE;
            int curNext = Integer.MAX_VALUE;
            if (pre >= 0) {
                curFirst = x - arr[pre];
            }
            if (next < arr.length) {
                curNext = arr[next] - x;
            }
            if (curFirst <= curNext) {
                queue.addFirst(arr[pre--]);
            } else {
                queue.add(arr[next++]);
            }
        }
        return (List<Integer>) queue;
    }

    private int fun(int[] arr, int x) {
        int left = 0;
        int right = arr.length;
        int mid=left+(right-left)/2;
        while (left < right) {
             mid = left + (right - left) / 2;
            if (arr[mid] <x) {
                left = mid +1;
            } else if (arr[mid] > x) {
                right = mid;
            }else {
                return mid;
            }
        }
        if(mid>1&&arr[mid]>x){
            mid--;
        }
        return mid;
    }
}
