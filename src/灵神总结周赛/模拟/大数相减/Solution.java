package 灵神总结周赛.模拟.大数相减;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.SubtractLargeNumbers("1267819", "123456789"));
    }

    public String SubtractLargeNumbers(String f, String s) {
        String preF = f;
        char sign = (f = getMax(f, s)).equals(s) ? '-' : '+';
        s = f.equals(s) ? preF : s;
        int borrow = 0;
        int fLen = f.length() - 1;
        int sLen = s.length() - 1;
        StringBuilder ans = new StringBuilder();
        while (fLen >= 0 || sLen >= 0) {
            int fa = fLen >= 0 ? f.charAt(fLen--) - '0' : 0;
            int sa = sLen >= 0 ? s.charAt(sLen--) - '0' : 0;
            int curSub = fa - sa - borrow;
            if (curSub < 0) {
                curSub += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            ans.append(curSub);
        }
        ans.reverse();
        int index = 0;
        while (index < ans.length() && ans.charAt(index) == '0') {
            index++;
        }
        return sign == '-' ? "-" + ans.substring(index) : ans.substring(index);
    }

    private String getMax(String f, String s) {
        if (f.length() > s.length()) {
            return f;
        } else if (f.length() < s.length()) {
            return s;
        } else {
            return f.compareTo(s) > 0 ? f : s;
        }
    }
}
