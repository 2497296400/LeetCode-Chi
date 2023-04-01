package Top集合.缺失的第一个正数;

public class SOlution {
    public static void main(String[] args) {
        SOlution sOlution = new SOlution();
        int[] arr = {-1, -1, -1, 1, 2, 1, 2, 3};
        System.out.println(sOlution.firstMissingPositive(arr));
       
    }

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
    
    private void swap(int[] nums, int first, int second) {
        int t = nums[first];
        nums[first] = nums[second];
        nums[second] = t;
    }
}
