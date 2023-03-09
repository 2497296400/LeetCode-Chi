package Top集合.计算右侧小于当前元素的个数;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    int[] index;
    int[] help;
    int[] count;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int []arr={0,2,1};
        System.out.println(solution.countSmaller(arr));
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        index = new int[nums.length];
        help = new int[nums.length];
        count = new int[nums.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        megerSort(nums, 0, nums.length - 1);
        for (int i : count) {
            ans.add(i);
        }
        return ans;
    }

    private void megerSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        megerSort(nums, left, mid);
        megerSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int curL = left;
        int curM = mid+1;
        int k = 0;
        while (curL <= mid && curM <= right) {
            if (nums[index[curL]] <= nums[index[curM]]) {
                help[k++] = index[curM++];
            } else {
                count[index[curL]] += right - curM + 1;
                help[k++] = index[curL++];
            }
        }
        while (curL <= mid) {
            help[k++] = index[curL++];
        }
        while (curM <= right) {
            help[k++] = index[curM++];
        }
        for (int cur = 0; cur < k; cur++) {
            index[left + cur] = help[cur];
        }
    }
}
