package 丑数系列.丑数I;


public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("123132");
        System.out.println(solution.isUgly(8));
    }

    public boolean isUgly(int n) {
        if (n == 1) {
            return true;
        }
        int[] nums = {2, 3, 5};

        while (n >= 1) {
            boolean is = false;
            for (int num : nums) {
                if (n % num == 0) {
                    n /= num;
                    is = true;
                }
            }
            if (!is) {
                return n == 1;
            }
        }
        return n == 1;
    }
}
