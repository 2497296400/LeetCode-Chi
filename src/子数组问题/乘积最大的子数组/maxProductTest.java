package 子数组问题.乘积最大的子数组;

public class maxProductTest {
    public int maxProduct_SB_Test(int[] nums) {
        int ans = 1;
        int indeZero = 0;
        int indexFu = 0;
        if (nums.length < 1) {
            return 0;
        }
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            ans = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                ans *= nums[j];
                max = Math.max(max, ans);
            }
        }
        return max;
    }
    public int maxProduct(int[] nums) {
        int asn = 1;
        int max = nums[0];
        for (int num : nums) {
            asn *= num;
            max=Math.max(max, asn);
            if (num == 0) {
                asn = 1;
            }
        }
        asn = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            asn *= nums[i];
            max=Math.max(max, asn);
            if (nums[i] == 0) {
                asn = 1;
            }
        }
        return max;
    }
}

