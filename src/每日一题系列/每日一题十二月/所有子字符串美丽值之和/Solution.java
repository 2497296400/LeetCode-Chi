package 每日一题系列.每日一题十二月.所有子字符串美丽值之和;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.beautySum("xzvfsppsjfbxdwkqe"));
    }

    public int beautySum(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = 0; i <= chars.length; i++) {
            for (int j = 0; j <= i - 3; j++) {
                sum += tofun(s, i, j);
            }
        }
        return sum;
    }

    private int tofun(String s, int i, int j) {
        String substring = s.substring(j, i);
        int[] arr = new int[26];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (char c : substring.toCharArray()) {
            arr[c - 'a']++;
        }
        for (int i1 : arr) {
            if (i1 != 0) {
                min = Math.min(min, i1);
                max = Math.max(max, i1);
            }
        }

        return max - min;
    }
}
