package 重复数快慢指针;
//快慢指针
public class Solution01 {
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int first = 0;
        int last = 0;
        do {
            last = nums[last];
            first = nums[nums[first]];
        } while (first != last);
        last = 0;
        do {
            last = nums[last];
            first = nums[first];
        } while (last != first);
        return last;
    }
}
