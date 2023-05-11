package 周赛.三百三十九场.第一题;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTheLongestBalancedSubstring("01000111"));
    }

    public int findTheLongestBalancedSubstring(String s) {
        int ans = 0;
        char[] array = s.toCharArray();
        for (int i = 2; i <= array.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((i - j) % 2 == 0) {
                    ans = Math.max(ans, toGet(s.substring(j, i)));
                }
            }
        }
        return ans;
    }

    private int toGet(String substring) {
        int target = substring.length() / 2;
        char at = substring.charAt(0);
        if(at!='0'){
            return 0;
        }
        int len = 0;
        for (int i = 0; i < target; i++) {
            if (substring.charAt(i) == at) {
                len++;
            } else {
                return 0;
            }
        }
        for (int i = target; i < substring.length(); i++) {
            if(substring.charAt(i)!=at){
                len++;
            }else{
                return 0;
            }
        }
        return len;
    }
}
