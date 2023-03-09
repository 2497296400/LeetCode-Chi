package 周赛.三百一十三场.最小XOR;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimizeXor(1, 12));

    }

    public int minimizeXor(int num1, int num2) {
        int curOne = 0;
        int max = 0;
        for (int i = 31; i >= 0; i--) {
            if (((num2 >> i) & 1) == 1) {
                curOne++;
                max = Math.max(max, i + 1);
            }
        }
        int sum1 = 0;
        int max1 = 0;
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            if (((num1 >> i) & 1) == 1) {
                max1 = Math.max(max1, i + 1);
                sum1++;
            }
        }
        int curcur = curOne;
        int curMax = Math.max(max1, curOne);
        int[] nums = new int[31];
        for (int i = curMax - 1; i >= 0; i--) {
            if (((num1 >> i) & 1) == 1 && curOne > 0) {
                curOne--;
                nums[i] = 1;
            } else if (max1 < curcur && curOne > 0) {
                nums[i] = 1;
                curOne--;
            }
        }
        for (int i = 0; i < 31; i++) {
            if (curOne > 0 && nums[i] != 1) {
                nums[i] = 1;
                curOne--;
            }
        }
        for (int i = 0; i < 31; i++) {
            if (nums[i] == 1) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
