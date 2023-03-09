package 每日一题系列.每日一题九月.字符串轮转;


public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println(solution.isFlipedString(s1, s2));

    }
    int cl = 0;
    public boolean isFlipedString(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int tl = 0;
        if (c1.length != c2.length) {
            return false;
        }
        while (cl < c1.length && tl < c2.length) {
            if (c1[cl] == c2[tl]) {
                if (fun(c1, c2, tl)) {
                    break;
                } else {
                    tl++;
                }
            } else {
                tl++;
                cl = 0;
            }
        }
        String cur = s1.substring(cl, s1.length());
        String s = s2.substring(0, tl);
        return cur.equals(s);
    }

    private boolean fun(char[] c1, char[] c2, int tl) {
        while (c1[cl++] == c2[tl++]) {
            if (tl == c2.length) {
                return true;
            }
        }
        return false;
    }
}
