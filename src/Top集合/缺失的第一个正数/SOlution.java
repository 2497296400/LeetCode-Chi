package Top集合.缺失的第一个正数;

public class SOlution {
    public static void main(String[] args) {
        SOlution sOlution = new SOlution();
        int[] arr = {-1, -1, -1, 1, 2, 1, 2, 3};
        System.out.println(sOlution.firstMissingPositive(arr));
        System.out.println(sOlution.find(arr));
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

    public int find(int[] arr) {
        int l = 0;
        int r = arr.length;
        while (l != r) {
            if (arr[l] == l + 1) {
                l++;
            } else if (arr[l] > r || arr[l] <= l) {
                swap(arr, l, --r);
            } else {
                swap(arr, arr[l], l + 1);
            }
        }
        return l + 1;
    }
    private void swap(int[] nums, int first, int second) {
        int t = nums[first];
        nums[first] = nums[second];
        nums[second] = t;
    }
}
