package 每日一题系列.每日一题三月.分割两个字符串得到回文串;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = "agdef";
        String b = "fecab";
        System.out.println(solution.checkPalindromeFormation(a, b));
    }

    public boolean checkPalindromeFormation(String a, String b) {
        return toCheck(a, b) || toCheck(b, a);
    }

    private boolean toCheck(String a, String b) {
        int l = 0, r = b.length() - 1;
        while (l <= r) {
            if (a.charAt(l) == b.charAt(r)) {
                l++;
                r--;
            } else {
                break;
            }
        }
        return Check(a, l, r) || Check(b, l, r);
    }
    
    private boolean Check(String a, int l, int r) {
        while (l < r) {
            if (a.charAt(l) != a.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
