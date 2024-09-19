package 每日一题系列.每日一题七月.满足距离约束且字典序最小的字符串;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getSmallestString("zbbz", 3));
    }
    public String getSmallestString(String s, int k) {
        char[] array = s.toCharArray();
        int n = array.length;
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = array[i] - 'a';
        }
        for (int i = 0; i < n; i++) {
            int lessPre = nums[i];
            int lessNext = 26 - nums[i];
            int curLess = Math.min(lessPre, lessNext);
            if (k >= curLess) {
                k -= curLess;
                nums[i] = 0;
            } else {
                nums[i] = nums[i] - k;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append((char) (num + 'a' ));
        }
        return sb.toString();
    }
}
