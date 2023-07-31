package 动态规划问题.最长无重复子串;

public class Dome {
    public static void main(String[] args) {
        Solution s=new Solution();
        String str="abcae";
        System.out.println(Solution.lengthOfLongestSubstring(str));
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.longestNonRepeatingSubstring(str));
    }
}
