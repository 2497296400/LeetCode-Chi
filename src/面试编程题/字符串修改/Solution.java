package 面试编程题.字符串修改;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations("1001101"));
    }
    public int minOperations(String str) {
        char[] array = str.toCharArray();
        int ans = 0;
        int sum = 0;
        ans = Math.min(toGet(0, '0', array), toGet(0, '1', array));
        return ans;
    }

    private int toGet(int start, char c, char[] array) {
        int sum = 0;
        for (int i = start; i < array.length; i++) {
            if (array[i] == c ) {
                sum++;
                i++;
            }
        }
        return sum;
    }
}
